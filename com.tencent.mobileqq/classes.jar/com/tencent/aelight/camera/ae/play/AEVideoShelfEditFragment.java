package com.tencent.aelight.camera.ae.play;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.AEPath;
import com.tencent.aelight.camera.ae.AEPath.PLAY.CACHE;
import com.tencent.aelight.camera.ae.AEPath.PLAY.FILES;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.HwVideoMerge;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.edit.NodeText;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeGroup;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import com.tencent.ttpic.videoshelf.parser.TemplateParser;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import org.light.device.OfflineConfig;

public class AEVideoShelfEditFragment
  extends PublicBaseFragment
  implements View.OnClickListener, EditTextViewer.OnDownloadDialogListener, EditTextViewer.OnSaveTextInfoListener, FaceImageViewer.OnSaveScrollInfoListener, ScaleMoveImageViewer.OnSaveScrollInfoListener, PublicFragmentActivityCallBackInterface
{
  private static int AUDIO_UPDATE_PROGRESS_TIME = 200;
  private static final long INTERVAL_UPDATE_PROGRESS = 200L;
  private static final int INVALID_NODEGROUPID = -1;
  private static double PROCESS_STEP = 0.3D;
  private static final String TAG = "AEVideoShelfEditFrag";
  private static final float WIDTH_BY_DESIGNER_USED = 720.0F;
  private static final int ZINDEX_BOUND = 10000;
  private static final float spacingInPixels = 12.0F;
  private static PowerManager.WakeLock wakeLock;
  private final String IMAGE_MULTI_FACE = "1";
  private final String IMAGE_NO_FACE = "2";
  private final String IMAGE_SINGLE_FACE = "0";
  private String mAudioPath;
  private Bitmap mBackgroundBitmap;
  private ImageView mBackgroundImageView;
  private List<Bitmap> mBitmaps = new ArrayList();
  private RecyclerView mBoxRecycleView;
  private View mButtonCancel;
  private View mButtonChangeImage;
  private TextView mButtonOk;
  private RelativeLayout mCenterView;
  private int mCenterViewHeight = 0;
  private int mCenterViewWidth = 0;
  private int mCurrentFaceImageViewerNodeId = 0;
  private Dialog mDialog;
  private VideoShelfEngine mEngine;
  private HashSet<FaceImageViewer> mFaceImageViewerSet = new HashSet();
  private String mFinalVideoPath;
  private long mGenerateBegin;
  private HashSet<ScaleMoveImageViewer> mImageViewerSet = new HashSet();
  private Boolean mIsSavingVideo = Boolean.valueOf(false);
  private int mJumpFrom;
  private long mLastUpdateProgressTimeMs;
  private Dialog mLoadingDialog;
  private String mMaterialId;
  private List<NodeGroup> mNodeGroupList = new ArrayList();
  private SparseIntArray mNodeSourceMap = new SparseIntArray();
  private VideoListAdapter.OnVideoNodeClickedListener mOnVideoNodeClickedListener = new AEVideoShelfEditFragment.20(this);
  private int mPrePos = 0;
  private double mProgress = 0.0D;
  private Map<String, Bitmap> mSourceBitmaps = new HashMap();
  private ArrayList<String> mSourcePhotoList;
  private String mTakeSameName;
  private VideoShelfTemplate mTemplate;
  private String mTemplatePath;
  private HashSet<EditTextViewer> mTextViewerSet = new HashSet();
  private Timer mTimer = new Timer();
  private VideoListAdapter mVideoListAdapter;
  private String outputDir;
  private String playShowTabName;
  ProgressPieDrawable ppd;
  
  private void checkJumpToPreview(Intent paramIntent)
  {
    if (this.mJumpFrom == 3)
    {
      getBaseActivity().setResult(-1, paramIntent);
      getBaseActivity().finish();
      return;
    }
    AEVideoShelfPreviewFragment.jumpToMe(getBaseActivity(), paramIntent, 2);
  }
  
  private void clearTempFiles()
  {
    Object localObject1 = new File(this.outputDir);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).list();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          localObject2 = new File(this.outputDir, (String)localObject2);
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
          i += 1;
        }
      }
    }
  }
  
  private ProgressPieDrawable createProgressPie()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(getBaseActivity());
    localProgressPieDrawable.a(AIOUtils.b(50.0F, getBaseActivity().getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.h(-1);
    localProgressPieDrawable.g(0);
    localProgressPieDrawable.e(-15550475);
    localProgressPieDrawable.j(3);
    localProgressPieDrawable.D = true;
    localProgressPieDrawable.A = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new AEVideoShelfEditFragment.3(this));
    return localProgressPieDrawable;
  }
  
  private void detectFaceInternal(FaceImageViewer paramFaceImageViewer, Bitmap paramBitmap)
  {
    paramBitmap = FaceChangeUtils.detectFace(paramBitmap, 0.1666666666666667D);
    int i = paramBitmap.getFaceCount();
    Object localObject1 = new ArrayList();
    paramBitmap = paramBitmap.getFaceInfoList().iterator();
    Object localObject2;
    while (paramBitmap.hasNext())
    {
      localObject2 = (FaceInfo)paramBitmap.next();
      CosFunUtil.scale(((FaceInfo)localObject2).points, 6.0D);
      FaceOffUtil.getFullCoords(((FaceInfo)localObject2).points, 1.5F);
      Object localObject3 = (PointF)((FaceInfo)localObject2).points.get(99);
      PointF localPointF = (PointF)((FaceInfo)localObject2).points.get(103);
      localObject3 = new FaceParam((int)((PointF)localObject3).x, (int)((PointF)localObject3).y, (int)localPointF.x, (int)localPointF.y);
      ((FaceParam)localObject3).angles = ((FaceInfo)localObject2).angles;
      ((List)localObject1).add(localObject3);
    }
    paramBitmap = new StringBuilder();
    paramBitmap.append("[PlayShow] onFaceImageChanged faceCount = ");
    paramBitmap.append(i);
    AEQLog.a("AEVideoShelfEditFrag", paramBitmap.toString());
    if (i >= 1)
    {
      paramBitmap = (FaceParam)((List)localObject1).get(0);
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (FaceParam)((Iterator)localObject2).next();
        if (((FaceParam)localObject1).getArea() > paramBitmap.getArea()) {
          paramBitmap = (Bitmap)localObject1;
        }
      }
      UiThreadUtil.a(new AEVideoShelfEditFragment.10(this, paramFaceImageViewer, paramBitmap));
      return;
    }
    UiThreadUtil.a(new AEVideoShelfEditFragment.11(this));
  }
  
  private void dismissProgressDialog()
  {
    Dialog localDialog = this.mDialog;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  public static int dp2px(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  private NodeItem findNodeItemById(NodeGroup paramNodeGroup, int paramInt)
  {
    paramNodeGroup = paramNodeGroup.nodeItemList.iterator();
    while (paramNodeGroup.hasNext())
    {
      NodeItem localNodeItem = (NodeItem)paramNodeGroup.next();
      if (paramInt == localNodeItem.nodeID) {
        return localNodeItem;
      }
    }
    return null;
  }
  
  private void finishAudioVideoMerge()
  {
    if (this.mTemplate != null)
    {
      Object localObject1 = this.mEngine;
      if (localObject1 == null) {
        return;
      }
      this.mFinalVideoPath = ((VideoShelfEngine)localObject1).getOutputVideoPath();
      this.mAudioPath = this.mTemplate.getAudioPath();
      localObject1 = this.mAudioPath;
      if (localObject1 != null) {
        localObject1 = new File((String)localObject1);
      } else {
        localObject1 = null;
      }
      boolean bool = hasStoragePermission(BaseApplicationImpl.getContext());
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localObject1 = this.mAudioPath;
        if ((localObject1 != null) && (((String)localObject1).toLowerCase().endsWith(".m4a")))
        {
          if (bool)
          {
            localObject1 = AEPath.a(AEPath.a());
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(AEPath.PLAY.FILES.f);
            ((StringBuilder)localObject1).append(File.separator);
            localObject1 = AEPath.a(((StringBuilder)localObject1).toString());
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("outputDir: ");
          localStringBuilder.append((String)localObject1);
          Object localObject2;
          if (new File((String)localObject1).exists()) {
            localObject2 = " exist";
          } else {
            localObject2 = " not exist";
          }
          localStringBuilder.append((String)localObject2);
          AEQLog.b("AEVideoShelfEditFrag", localStringBuilder.toString());
          this.mTimer = new Timer();
          this.mTimer.schedule(new AEVideoShelfEditFragment.16(this), 0L, AUDIO_UPDATE_PROGRESS_TIME);
          if (HwVideoMerge.a(this.mEngine.getOutputVideoPath(), this.mAudioPath, (String)localObject1, 0) == 0)
          {
            localObject2 = new File(this.mEngine.getOutputVideoPath());
            if (((File)localObject2).exists())
            {
              AEQLog.b("AEVideoShelfEditFrag", "finishAudioVideoMerge done!");
              ((File)localObject2).delete();
            }
            this.mFinalVideoPath = ((String)localObject1);
          }
          this.mTimer.cancel();
          this.mTimer = null;
        }
      }
      if ((bool) && (this.mFinalVideoPath != null)) {
        FileUtils.a(BaseApplication.getContext(), new File(this.mFinalVideoPath));
      }
    }
  }
  
  private boolean finishEditTemplate()
  {
    Iterator localIterator = this.mImageViewerSet.iterator();
    Object localObject3 = null;
    int k = 0;
    Object localObject1 = null;
    int i = 0;
    Object localObject4;
    while (localIterator.hasNext())
    {
      localObject4 = (ScaleMoveImageViewer)localIterator.next();
      localObject2 = localObject1;
      j = i;
      if (!((ScaleMoveImageViewer)localObject4).isImageSelected())
      {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (localObject1.getNodeGroupID() <= ((ScaleMoveImageViewer)localObject4).getNodeGroupID()) {}
        }
        else
        {
          localObject2 = localObject4;
        }
        j = 1;
      }
      localObject1 = localObject2;
      i = j;
      if (j == 0)
      {
        ((ScaleMoveImageViewer)localObject4).updateCropBitmap();
        localObject1 = localObject2;
        i = j;
      }
    }
    localIterator = this.mFaceImageViewerSet.iterator();
    int j = k;
    Object localObject2 = localObject3;
    while (localIterator.hasNext())
    {
      localObject4 = (FaceImageViewer)localIterator.next();
      localObject3 = localObject2;
      k = j;
      if (!((FaceImageViewer)localObject4).isImageSelected())
      {
        if (localObject2 != null)
        {
          localObject3 = localObject2;
          if (localObject2.getNodeGroupID() <= ((FaceImageViewer)localObject4).getNodeGroupID()) {}
        }
        else
        {
          localObject3 = localObject4;
        }
        k = 1;
      }
      localObject2 = localObject3;
      j = k;
      if (k == 0)
      {
        ((FaceImageViewer)localObject4).updateCropBitmap();
        localObject2 = localObject3;
        j = k;
      }
    }
    int m = -1;
    k = m;
    if (i != 0)
    {
      k = m;
      if (localObject1 != null) {
        k = Math.max(localObject1.getNodeGroupID(), -1);
      }
    }
    if ((j != 0) && (localObject2 != null)) {
      Math.max(localObject2.getNodeGroupID(), k);
    }
    return true;
  }
  
  private static Bitmap getBitmapFromView(RelativeLayout paramRelativeLayout, int paramInt1, int paramInt2)
  {
    if (paramRelativeLayout == null) {
      return null;
    }
    paramRelativeLayout.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    paramRelativeLayout.draw(new Canvas(localBitmap));
    paramRelativeLayout = Bitmap.createScaledBitmap(localBitmap, paramInt1 / 4, paramInt2 / 4, false);
    localBitmap.recycle();
    return paramRelativeLayout;
  }
  
  private Bitmap getCenterViewBitmap()
  {
    int i = this.mCenterViewWidth;
    if (i > 0)
    {
      int j = this.mCenterViewHeight;
      if (j > 0)
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (!BitmapUtils.isLegal(localBitmap2))
        {
          Log.e("AEVideoShelfEditFrag", "CenterView bitmap is null");
          return null;
        }
        Canvas localCanvas = new Canvas(localBitmap2);
        RelativeLayout localRelativeLayout = this.mCenterView;
        localBitmap1 = localBitmap2;
        if (localRelativeLayout == null) {
          return localBitmap1;
        }
        localRelativeLayout.draw(localCanvas);
        return localBitmap2;
      }
    }
    Bitmap localBitmap1 = null;
    return localBitmap1;
  }
  
  private FaceImageViewer getFaceImageViewByNodeId(int paramInt)
  {
    Iterator localIterator = this.mFaceImageViewerSet.iterator();
    while (localIterator.hasNext())
    {
      FaceImageViewer localFaceImageViewer = (FaceImageViewer)localIterator.next();
      if (localFaceImageViewer.getNodeID() == paramInt) {
        return localFaceImageViewer;
      }
    }
    return null;
  }
  
  private ScaleMoveImageViewer getImageViewByNodeId(int paramInt)
  {
    Iterator localIterator = this.mImageViewerSet.iterator();
    while (localIterator.hasNext())
    {
      ScaleMoveImageViewer localScaleMoveImageViewer = (ScaleMoveImageViewer)localIterator.next();
      if (localScaleMoveImageViewer.getNodeID() == paramInt) {
        return localScaleMoveImageViewer;
      }
    }
    return null;
  }
  
  private void goNext()
  {
    if (finishEditTemplate())
    {
      if (!isNeedRealTimePlay())
      {
        saveVideoTemplate();
        return;
      }
      startVideoTemplateSaveActivity(true);
    }
  }
  
  static boolean hasStoragePermission(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    return PermissionUtils.isStorePermissionEnable(paramContext);
  }
  
  private void hideLoading()
  {
    Object localObject = getBaseActivity();
    if ((localObject != null) && (!((BaseActivity)localObject).isFinishing()))
    {
      localObject = this.mLoadingDialog;
      if ((localObject != null) && (((Dialog)localObject).isShowing())) {
        this.mLoadingDialog.dismiss();
      }
    }
  }
  
  private void imageLayout(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    boolean bool = paramImageView instanceof ScaleMoveImageViewer;
    NodeItem localNodeItem;
    if (bool) {
      localNodeItem = ((ScaleMoveImageViewer)paramImageView).getNode();
    } else if ((paramImageView instanceof FaceImageViewer)) {
      localNodeItem = ((FaceImageViewer)paramImageView).getNode();
    } else if ((paramImageView instanceof EditTextViewer)) {
      localNodeItem = ((EditTextViewer)paramImageView).getNode();
    } else {
      localNodeItem = null;
    }
    if (localNodeItem != null)
    {
      float f2 = localNodeItem.maskRect.left;
      float f1 = paramInt1;
      paramInt1 = (int)(f2 * f1);
      f2 = localNodeItem.maskRect.top;
      float f3 = paramInt2;
      paramInt2 = (int)(f2 * f3);
      int i = (int)(localNodeItem.maskRect.right * f1);
      int j = (int)(localNodeItem.maskRect.bottom * f3);
      int k = i - paramInt1;
      int m = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
      int n = j - paramInt2;
      paramImageView.measure(m, View.MeasureSpec.makeMeasureSpec(n, 1073741824));
      paramImageView.layout(paramInt1, paramInt2, i, j);
      if (bool)
      {
        ((ScaleMoveImageViewer)paramImageView).updateMatrix(Math.abs(k), Math.abs(n));
        return;
      }
      if ((paramImageView instanceof FaceImageViewer))
      {
        ((FaceImageViewer)paramImageView).updateMatrix(Math.abs(k), Math.abs(n));
        return;
      }
      if ((paramImageView instanceof EditTextViewer))
      {
        paramImageView = (EditTextViewer)paramImageView;
        paramImageView.updateMatrix(Math.abs(k), Math.abs(n));
        paramImageView.setActionBarHeight(getResources().getDimensionPixelSize(2131297050));
      }
    }
  }
  
  private void initAllNodeViewer()
  {
    this.mNodeSourceMap.clear();
    Iterator localIterator1 = this.mNodeGroupList.iterator();
    int i = 0;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((NodeGroup)localIterator1.next()).nodeItemList.iterator();
      int j = i;
      NodeItem localNodeItem;
      Object localObject;
      do
      {
        i = j;
        if (!localIterator2.hasNext()) {
          break;
        }
        localNodeItem = (NodeItem)localIterator2.next();
        if (localNodeItem.type != 0) {
          break label210;
        }
        localObject = new ScaleMoveImageViewer(getBaseActivity());
        ((ScaleMoveImageViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new AEVideoShelfEditFragment.6(this, (ScaleMoveImageViewer)localObject, localNodeItem));
        ((ScaleMoveImageViewer)localObject).setOnSaveScrollInfoListener(this);
        ((ScaleMoveImageViewer)localObject).setNodeInfo(localNodeItem);
        ((ScaleMoveImageViewer)localObject).setMovable(false);
        ((ScaleMoveImageViewer)localObject).setImageSelected(false);
        this.mImageViewerSet.add(localObject);
        localObject = this.mSourcePhotoList;
      } while ((localObject == null) || (j >= ((ArrayList)localObject).size()));
      onImageChanged(localNodeItem.nodeID, (String)this.mSourcePhotoList.get(j), false);
      this.mNodeSourceMap.put(localNodeItem.nodeID, j);
      for (;;)
      {
        j += 1;
        break;
        label210:
        if (localNodeItem.type == 1)
        {
          localObject = new EditTextViewer(getBaseActivity());
          ((EditTextViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new AEVideoShelfEditFragment.7(this, (EditTextViewer)localObject, localNodeItem));
          ((EditTextViewer)localObject).setOnSaveTextInfoListener(this);
          ((EditTextViewer)localObject).setOnDownloadDialogListener(this);
          ((EditTextViewer)localObject).setNodeInfo(localNodeItem);
          if (localNodeItem.bitmap != null)
          {
            ((EditTextViewer)localObject).setImageBitmap(localNodeItem.bitmap);
          }
          else
          {
            Bitmap localBitmap = ((EditTextViewer)localObject).renderBitmap();
            if ((localBitmap != null) && (!localBitmap.isRecycled()))
            {
              ((EditTextViewer)localObject).setImageBitmap(localBitmap);
              localNodeItem.bitmap = localBitmap;
              ((EditTextViewer)localObject).setImageBitmap(localNodeItem.bitmap);
            }
          }
          ((EditTextViewer)localObject).setNodeBitmap(localNodeItem.bitmap);
          ((EditTextViewer)localObject).setTextSelected(true);
          ((EditTextViewer)localObject).setMaterialId(this.mMaterialId);
          this.mTextViewerSet.add(localObject);
          break;
        }
        if (localNodeItem.type != 2) {
          break;
        }
        localObject = new FaceImageViewer(getBaseActivity());
        ((FaceImageViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new AEVideoShelfEditFragment.8(this, (FaceImageViewer)localObject, localNodeItem));
        ((FaceImageViewer)localObject).setOnSaveScrollInfoListener(this);
        ((FaceImageViewer)localObject).setNodeInfo(localNodeItem);
        ((FaceImageViewer)localObject).setMovable(false);
        ((FaceImageViewer)localObject).setImageSelected(false);
        this.mFaceImageViewerSet.add(localObject);
        localObject = this.mSourcePhotoList;
        if ((localObject == null) || (j >= ((ArrayList)localObject).size())) {
          break;
        }
        onFaceImageChanged(localNodeItem.nodeID, (String)this.mSourcePhotoList.get(j), false);
        this.mNodeSourceMap.put(localNodeItem.nodeID, j);
      }
    }
  }
  
  private void initBackgroundImageView()
  {
    this.mBackgroundImageView = new ImageView(getBaseActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.mBackgroundImageView.setLayoutParams(localLayoutParams);
  }
  
  private void initCenterView(int paramInt)
  {
    NodeGroup localNodeGroup = (NodeGroup)this.mNodeGroupList.get(paramInt);
    this.mCenterView.removeAllViews();
    Iterator localIterator = this.mImageViewerSet.iterator();
    label31:
    Object localObject;
    for (paramInt = 0; localIterator.hasNext(); paramInt = 1)
    {
      localObject = (ScaleMoveImageViewer)localIterator.next();
      if ((((ScaleMoveImageViewer)localObject).getNodeGroupID() != localNodeGroup.nodeGroupID) || (((ScaleMoveImageViewer)localObject).getNode().zIndex >= 10000)) {
        break label31;
      }
      this.mCenterView.addView((View)localObject);
    }
    localIterator = this.mTextViewerSet.iterator();
    while (localIterator.hasNext())
    {
      localObject = (EditTextViewer)localIterator.next();
      if ((((EditTextViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject).getNode().zIndex < 10000)) {
        this.mCenterView.addView((View)localObject);
      }
    }
    localIterator = this.mFaceImageViewerSet.iterator();
    while (localIterator.hasNext())
    {
      localObject = (FaceImageViewer)localIterator.next();
      if ((((FaceImageViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject).getNode().zIndex < 10000)) {
        this.mCenterView.addView((View)localObject);
      }
    }
    setBackgroundImage(localNodeGroup);
    this.mCenterView.addView(this.mBackgroundImageView);
    localIterator = this.mImageViewerSet.iterator();
    while (localIterator.hasNext())
    {
      localObject = (ScaleMoveImageViewer)localIterator.next();
      if ((((ScaleMoveImageViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject).getNode().zIndex >= 10000))
      {
        this.mCenterView.addView((View)localObject);
        paramInt = 1;
      }
    }
    localIterator = this.mTextViewerSet.iterator();
    while (localIterator.hasNext())
    {
      localObject = (EditTextViewer)localIterator.next();
      if ((((EditTextViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject).getNode().zIndex >= 10000)) {
        this.mCenterView.addView((View)localObject);
      }
    }
    localIterator = this.mFaceImageViewerSet.iterator();
    while (localIterator.hasNext())
    {
      localObject = (FaceImageViewer)localIterator.next();
      if ((((FaceImageViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject).getNode().zIndex >= 10000)) {
        this.mCenterView.addView((View)localObject);
      }
    }
    if (paramInt != 0)
    {
      this.mButtonChangeImage.setVisibility(0);
      return;
    }
    this.mButtonChangeImage.setVisibility(8);
  }
  
  private void initData()
  {
    Object localObject = getBaseActivity().getIntent();
    if (localObject == null) {
      return;
    }
    this.mJumpFrom = ((Intent)localObject).getIntExtra("jump_in_from", 0);
    this.playShowTabName = ((Intent)localObject).getStringExtra("loc_play_show_tab_name");
    this.mTemplatePath = ((Intent)localObject).getStringExtra("MaterialPath");
    this.mMaterialId = ((Intent)localObject).getStringExtra("MaterialId");
    this.mSourcePhotoList = ((Intent)localObject).getStringArrayListExtra("PhotoList");
    this.mTakeSameName = ((Intent)localObject).getStringExtra("loc_play_show_take_same_name");
    this.mTemplate = TemplateParser.parse(getBaseActivity(), this.mTemplatePath);
    localObject = this.mTemplate;
    if (localObject == null)
    {
      AEQLog.c("AEVideoShelfEditFrag", "parse template Error!");
      return;
    }
    try
    {
      this.mEngine = new VideoShelfEngine(((VideoShelfTemplate)localObject).getVersion());
    }
    catch (PagNotSupportSystemException localPagNotSupportSystemException)
    {
      this.mEngine = null;
      AEQLog.d("AEVideoShelfEditFrag", localPagNotSupportSystemException.getMessage());
      UiThreadUtil.a(new AEVideoShelfEditFragment.4(this), 2000L);
    }
    if (this.mEngine == null)
    {
      AEQLog.c("AEVideoShelfEditFrag", "init Engine Error!");
      return;
    }
    new AEVideoShelfEditFragment.5(this).execute(new Void[0]);
  }
  
  private void initNodeGroup()
  {
    if (this.mTemplate == null) {
      return;
    }
    int i = 0;
    while (i < this.mTemplate.getNodeGroupList().size())
    {
      Object localObject1 = (MaskNodeGroup)this.mTemplate.getNodeGroupList().get(i);
      NodeGroup localNodeGroup = new NodeGroup();
      localNodeGroup.nodeCoverImage = ((MaskNodeGroup)localObject1).getNodeGroupCoverImage();
      localNodeGroup.nodeGroupID = ((MaskNodeGroup)localObject1).getNodeGroupID();
      localNodeGroup.nodeDefaultMaskCoverImage = ((MaskNodeGroup)localObject1).getNodeGroupMaskImage();
      localObject1 = ((MaskNodeGroup)localObject1).getNodeList();
      localNodeGroup.nodeItemList = new ArrayList();
      int j = 0;
      while (j < ((List)localObject1).size())
      {
        MaskNodeItem localMaskNodeItem = (MaskNodeItem)((List)localObject1).get(j);
        NodeItem localNodeItem = new NodeItem();
        localNodeItem.nodeID = localMaskNodeItem.getNodeID();
        Object localObject2 = localMaskNodeItem.getNodeDefaultMaskCoverImage();
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (localMaskNodeItem.getType() == 1) {
            localNodeItem.coverURL = null;
          } else {
            localNodeItem.coverURL = localNodeGroup.nodeDefaultMaskCoverImage;
          }
        }
        else {
          localNodeItem.coverURL = ((String)localObject2);
        }
        localObject2 = localMaskNodeItem.getMaskRect();
        localNodeItem.maskRect.set(localObject2[0], localObject2[1], localObject2[0] + localObject2[2], localObject2[1] + localObject2[3]);
        localNodeItem.once = true;
        localNodeItem.type = localMaskNodeItem.getType();
        localNodeItem.nodeGroupID = localMaskNodeItem.getNodeGroupID();
        localNodeItem.zIndex = localMaskNodeItem.getZIndex();
        localNodeItem.indexLayerForPag = localMaskNodeItem.getIndexLayerForPag();
        localNodeItem.nodeTextMaxCount = localMaskNodeItem.getNodeTextMaxCount();
        if (!TextUtils.isEmpty(localNodeItem.coverURL))
        {
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.mTemplate.getMaterialPath());
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append(localNodeItem.coverURL);
          localObject3 = ((StringBuilder)localObject3).toString();
          localNodeItem.bitmap = BitmapUtils.decodeSampleBitmap(getBaseActivity(), (String)localObject3, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
          localNodeItem.bitmap = VideoShelfBitmapUtils.rotateWithExif(localNodeItem.bitmap, (String)localObject3);
        }
        if (localMaskNodeItem.getNodeTextGroup() != null)
        {
          localNodeItem.nodeTextGroup.copyFrom(localMaskNodeItem.getNodeTextGroup());
          if (TextUtils.isEmpty(localNodeItem.nodeTextGroup.fmtstr))
          {
            localNodeItem.nodeTextGroup.fmtstr = "请输入文字";
            if ((localNodeItem.type == 1) && (localNodeItem.bitmap != null) && (!localNodeItem.bitmap.isRecycled()))
            {
              localNodeItem.bitmap.recycle();
              localNodeItem.bitmap = null;
            }
          }
          if ((TextUtils.isEmpty(localNodeItem.coverURL)) && (localNodeItem.type == 1) && (localNodeItem.bitmap != null) && (!localNodeItem.bitmap.isRecycled()))
          {
            localNodeItem.bitmap.recycle();
            localNodeItem.bitmap = null;
          }
          localNodeItem.nodeTextGroup.width = ((int)(this.mTemplate.getVideoWidth() * localObject2[2]));
          localNodeItem.nodeTextGroup.height = ((int)(this.mTemplate.getVideoHeight() * localObject2[3]));
          localNodeItem.nodeTextGroup.fontSize = (localNodeItem.nodeTextGroup.fontSize * this.mTemplate.getVideoWidth() / 720.0F);
        }
        this.mBitmaps.add(localNodeItem.bitmap);
        localNodeGroup.nodeItemList.add(localNodeItem);
        j += 1;
      }
      this.mNodeGroupList.add(localNodeGroup);
      i += 1;
    }
  }
  
  @TargetApi(14)
  private void initProgressDialog()
  {
    this.mDialog = new Dialog(getBaseActivity());
    Object localObject = this.mDialog.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject).setDimAmount(0.0F);
      }
    }
    this.mDialog.requestWindowFeature(1);
    this.mDialog.setContentView(2131628207);
    localObject = (ImageView)this.mDialog.findViewById(2131440726);
    this.ppd = createProgressPie();
    ((ImageView)localObject).setImageDrawable(this.ppd);
    ((TextView)this.mDialog.findViewById(2131438908)).setText(2064187599);
    this.mDialog.setCancelable(true);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.mDialog.setOnCancelListener(new AEVideoShelfEditFragment.2(this));
    this.ppd.d(0);
  }
  
  private void initSelectedFacePosition(FaceImageViewer paramFaceImageViewer, FaceParam paramFaceParam)
  {
    float f5 = paramFaceImageViewer.getWidth();
    float f6 = paramFaceImageViewer.getHeight();
    float f2 = (float)Math.toDegrees(paramFaceParam.angles[2]);
    float f1 = 1.0F;
    float f3 = f5 / 2.0F;
    float f4 = (paramFaceParam.mFace.left + paramFaceParam.mFace.right) / 2;
    f6 /= 2.0F;
    float f7 = (paramFaceParam.mFace.top + paramFaceParam.mFace.bottom) / 2;
    float f8 = paramFaceParam.mFace.width();
    if (f8 > 0.0F) {
      f1 = f5 / f8;
    }
    paramFaceImageViewer.transformCurrentMatrix(f1, f2 * 1.0F, f3 - f4, f6 - f7);
  }
  
  private void initSoftInputMode()
  {
    Window localWindow = getBaseActivity().getWindow();
    if (localWindow != null) {
      localWindow.setSoftInputMode(48);
    }
  }
  
  private void initView()
  {
    this.mButtonCancel = getBaseActivity().findViewById(2063990900);
    this.mButtonOk = ((TextView)getBaseActivity().findViewById(2063990925));
    this.mButtonOk.setText(2064187585);
    this.mButtonOk.setOnClickListener(this);
    this.mButtonCancel.setOnClickListener(this);
    this.mButtonChangeImage = getBaseActivity().findViewById(2063991023);
    this.mButtonChangeImage.setOnClickListener(this);
    this.mCenterView = ((RelativeLayout)getBaseActivity().findViewById(2063990963));
    this.mBoxRecycleView = ((RecyclerView)getBaseActivity().findViewById(2063990911));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getBaseActivity());
    localLinearLayoutManager.setOrientation(0);
    this.mBoxRecycleView.addItemDecoration(new AEVideoShelfEditFragment.SpacesItemDecoration(this, dp2px(getBaseActivity(), 12.0F)));
    this.mBoxRecycleView.setLayoutManager(localLinearLayoutManager);
    this.mCenterView.getViewTreeObserver().addOnGlobalLayoutListener(new AEVideoShelfEditFragment.1(this));
    initProgressDialog();
  }
  
  private boolean isNeedRealTimePlay()
  {
    VideoShelfTemplate localVideoShelfTemplate = this.mTemplate;
    boolean bool2 = false;
    if (localVideoShelfTemplate == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (localVideoShelfTemplate.getPagFileName() != null)
    {
      bool1 = bool2;
      if (this.mTemplate.getPagFilePath() != null)
      {
        bool1 = bool2;
        if (this.mTemplate.getPreviewVideoType() == 1)
        {
          bool1 = bool2;
          if (!OfflineConfig.isNotSuptPagRealTime()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static void jumpToMe(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList, int paramInt, String paramString5)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString2);
    localIntent.putExtra("MaterialId", paramString3);
    localIntent.putExtra("MaterialName", paramString4);
    localIntent.putExtra("loc_play_show_tab_name", paramString1);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.getFromType(paramContext));
    localIntent.putStringArrayListExtra("PhotoList", paramArrayList);
    localIntent.putExtra("jump_in_from", paramInt);
    localIntent.putExtra("loc_play_show_take_same_name", paramString5);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class);
  }
  
  public static void jumpToMeForResult(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString1);
    localIntent.putExtra("MaterialId", paramString2);
    localIntent.putExtra("MaterialName", paramString3);
    localIntent.putStringArrayListExtra("PhotoList", paramArrayList);
    localIntent.putExtra("jump_in_from", paramInt2);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class, paramInt1);
  }
  
  private void jumpToPagRealtimePreview()
  {
    Log.i("AEVideoShelfEditFrag", "未合成视频，将直接实时预览。");
    AEQLog.b("AEVideoShelfEditFrag", "未合成视频，将直接实时预览。");
    if (this.mTemplate == null) {
      return;
    }
    new AEVideoShelfEditFragment.12(this).execute(new Void[0]);
  }
  
  public static void keepScreenOn(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(536870918, AEVideoShelfEditFragment.class.getSimpleName());
      wakeLock.acquire();
      AEQLog.b("AEVideoShelfEditFrag", "keepScreenOn!");
      return;
    }
    paramContext = wakeLock;
    if (paramContext != null)
    {
      paramContext.release();
      wakeLock = null;
    }
    AEQLog.b("AEVideoShelfEditFrag", "keepScreenOff!");
  }
  
  private static void layoutView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824));
    paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  private void loadAllSrcBitmaps()
  {
    Object localObject = this.mSourcePhotoList;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return;
      }
      int i = 0;
      while (i < this.mSourcePhotoList.size())
      {
        localObject = (String)this.mSourcePhotoList.get(i);
        this.mSourceBitmaps.put(localObject, BitmapUtils.decodeSampleBitmap(getBaseActivity(), (String)localObject, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight()));
        i += 1;
      }
    }
  }
  
  private void onFaceImageChanged(int paramInt, String paramString, boolean paramBoolean)
  {
    this.mCurrentFaceImageViewerNodeId = paramInt;
    FaceImageViewer localFaceImageViewer = getFaceImageViewByNodeId(this.mCurrentFaceImageViewerNodeId);
    if (localFaceImageViewer == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bitmap localBitmap2 = (Bitmap)this.mSourceBitmaps.get(paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap1 = BitmapUtils.decodeSampleBitmap(getBaseActivity(), paramString, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
      this.mSourceBitmaps.put(paramString, localBitmap1);
    }
    if (!BitmapUtils.isLegal(localBitmap1)) {
      return;
    }
    localBitmap1 = VideoShelfBitmapUtils.rotateWithExif(localBitmap1, paramString);
    paramString = localBitmap1;
    if (localBitmap1.getWidth() == 1)
    {
      paramString = localBitmap1;
      if (localBitmap1.getHeight() == 1) {
        paramString = BitmapUtils.scaleBitmap(localBitmap1, 2.0F, true);
      }
    }
    localFaceImageViewer.setNodeBitmap(paramString);
    localFaceImageViewer.setImageBitmap(paramString);
    localFaceImageViewer.setImageSelected(true);
    localFaceImageViewer.setMovable(true);
    localFaceImageViewer.setScaleType(ImageView.ScaleType.MATRIX);
    localFaceImageViewer.clearSeclected();
    FaceChangeUtils.runInGLThread(new AEVideoShelfEditFragment.9(this, localFaceImageViewer, paramString), false, "");
    if (paramBoolean) {
      updateRVListItem(localFaceImageViewer.getNodeGroupID());
    }
  }
  
  private void onFirstImageViewClick(View paramView)
  {
    int i = ((NodeGroup)this.mNodeGroupList.get(this.mPrePos)).nodeGroupID;
    Object localObject = this.mImageViewerSet;
    if (localObject != null)
    {
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ScaleMoveImageViewer localScaleMoveImageViewer = (ScaleMoveImageViewer)((Iterator)localObject).next();
        if (localScaleMoveImageViewer.getNodeGroupID() == i) {
          localScaleMoveImageViewer.onClick(paramView);
        }
      }
    }
  }
  
  private void onImageChanged(int paramInt, String paramString)
  {
    onImageChanged(paramInt, paramString, true);
  }
  
  private void onImageChanged(int paramInt, String paramString, boolean paramBoolean)
  {
    ScaleMoveImageViewer localScaleMoveImageViewer = getImageViewByNodeId(paramInt);
    if (localScaleMoveImageViewer == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bitmap localBitmap2 = (Bitmap)this.mSourceBitmaps.get(paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap1 = BitmapUtils.decodeSampleBitmap(getBaseActivity(), paramString, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
      this.mSourceBitmaps.put(paramString, localBitmap1);
    }
    if (!BitmapUtils.isLegal(localBitmap1)) {
      return;
    }
    localBitmap1 = VideoShelfBitmapUtils.rotateWithExif(localBitmap1, paramString);
    paramString = localBitmap1;
    if (localBitmap1.getWidth() == 1)
    {
      paramString = localBitmap1;
      if (localBitmap1.getHeight() == 1) {
        paramString = BitmapUtils.scaleBitmap(localBitmap1, 2.0F, true);
      }
    }
    localScaleMoveImageViewer.setNodeBitmap(paramString);
    localScaleMoveImageViewer.setImageBitmap(paramString);
    localScaleMoveImageViewer.setImageSelected(true);
    localScaleMoveImageViewer.setMovable(true);
    localScaleMoveImageViewer.clearSeclected();
    if (paramBoolean) {
      updateRVListItem(localScaleMoveImageViewer.getNodeGroupID());
    }
  }
  
  private String saveMyBitmap(int paramInt, Bitmap paramBitmap)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.outputDir);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("output_");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(".png");
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = new File(str);
    try
    {
      ((File)localObject1).createNewFile();
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("error in saving png:");
      localStringBuilder2.append(localIOException.toString());
      AEQLog.c("AEVideoShelfEditFrag", localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1;
    Object localObject2;
    try
    {
      localObject1 = new FileOutputStream((File)localObject1);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("error in saving file:");
      localStringBuilder1.append(localFileNotFoundException.toString());
      AEQLog.c("AEVideoShelfEditFrag", localStringBuilder1.toString());
      localObject2 = null;
    }
    try
    {
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
      try
      {
        ((FileOutputStream)localObject2).flush();
      }
      catch (IOException paramBitmap)
      {
        paramBitmap.printStackTrace();
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("error in flush png:");
        localStringBuilder1.append(paramBitmap.toString());
        AEQLog.c("AEVideoShelfEditFrag", localStringBuilder1.toString());
      }
      try
      {
        ((FileOutputStream)localObject2).close();
        return str;
      }
      catch (IOException paramBitmap)
      {
        paramBitmap.printStackTrace();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("error in close file:");
        ((StringBuilder)localObject2).append(paramBitmap.toString());
        AEQLog.c("AEVideoShelfEditFrag", ((StringBuilder)localObject2).toString());
        return str;
      }
      return null;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("error in compress png:");
      ((StringBuilder)localObject2).append(paramBitmap.toString());
      AEQLog.c("AEVideoShelfEditFrag", ((StringBuilder)localObject2).toString());
    }
  }
  
  private void saveVideoTemplate()
  {
    Object localObject = this.mTemplate;
    if (localObject != null)
    {
      VideoShelfEngine localVideoShelfEngine = this.mEngine;
      if (localVideoShelfEngine == null) {
        return;
      }
      localVideoShelfEngine.setVideoFrameItemList(((VideoShelfTemplate)localObject).getFrameList());
      this.mEngine.setNodeGroupItemList(this.mNodeGroupList);
      this.mEngine.setVideoTemplateType(this.mTemplate.getVideoTemplateType());
      localObject = null;
      int i = this.mTemplate.getVersion();
      if (i != 0)
      {
        if (i == 1) {
          localObject = this.mTemplate.getPagFilePath();
        }
      }
      else {
        localObject = this.mTemplate.getVideoPath();
      }
      this.mEngine.setSrcPath((String)localObject);
      this.mEngine.setOutputVideoPath(ShortVideoUtils.getLocalShortVideoPath());
      this.mEngine.setCallback(new AEVideoShelfEditFragment.EngineCallback(this));
      this.mEngine.setLutPath(this.mTemplate.getFilterLutPath());
      if (this.mTemplate.getWatermarkRect() != null) {
        this.mEngine.setWatermarkRect(this.mTemplate.getWatermarkRect());
      }
      this.mIsSavingVideo = Boolean.valueOf(true);
      this.mEngine.save(this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
    }
  }
  
  private void setBackgroundImage(NodeGroup paramNodeGroup)
  {
    Object localObject = this.mBackgroundBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      this.mBackgroundBitmap.recycle();
    }
    if (this.mTemplate == null) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mTemplate.getMaterialPath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramNodeGroup.nodeDefaultMaskCoverImage);
    paramNodeGroup = ((StringBuilder)localObject).toString();
    this.mBackgroundBitmap = VideoShelfBitmapUtils.rotateWithExif(BitmapUtils.decodeSampleBitmap(getBaseActivity(), paramNodeGroup, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight()), paramNodeGroup);
    this.mBackgroundImageView.setImageBitmap(this.mBackgroundBitmap);
  }
  
  private void setListViewBg(int paramInt)
  {
    Object localObject = this.mBoxRecycleView;
    if (localObject != null)
    {
      localObject = (VideoListAdapter)((RecyclerView)localObject).getAdapter();
      Bitmap localBitmap = getCenterViewBitmap();
      if ((localObject != null) && (BitmapUtils.isLegal(localBitmap)))
      {
        ((VideoListAdapter)localObject).setThumbBackground(paramInt, localBitmap);
        ((VideoListAdapter)localObject).updateThumbBackground();
      }
    }
  }
  
  private void setListViewBg(RelativeLayout paramRelativeLayout, int paramInt)
  {
    Object localObject = this.mBoxRecycleView;
    if (localObject != null)
    {
      localObject = (VideoListAdapter)((RecyclerView)localObject).getAdapter();
      paramRelativeLayout = getBitmapFromView(paramRelativeLayout, paramRelativeLayout.getWidth(), paramRelativeLayout.getHeight());
      if ((localObject != null) && (BitmapUtils.isLegal(paramRelativeLayout)))
      {
        ((VideoListAdapter)localObject).setThumbBackground(paramInt, paramRelativeLayout);
        ((VideoListAdapter)localObject).updateThumbBackground();
      }
    }
  }
  
  private void setOffscreenView(ViewGroup paramViewGroup, int paramInt)
  {
    NodeGroup localNodeGroup = (NodeGroup)this.mNodeGroupList.get(paramInt);
    paramViewGroup.removeAllViews();
    Object localObject1 = this.mImageViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ScaleMoveImageViewer)((Iterator)localObject1).next();
      if ((((ScaleMoveImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject2).getNode().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
      }
    }
    localObject1 = this.mTextViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditTextViewer)((Iterator)localObject1).next();
      if ((((EditTextViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject2).getNode().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
      }
    }
    localObject1 = this.mFaceImageViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FaceImageViewer)((Iterator)localObject1).next();
      if ((((FaceImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject2).getNode().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mTemplate.getMaterialPath());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append(localNodeGroup.nodeDefaultMaskCoverImage);
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject1 = VideoShelfBitmapUtils.rotateWithExif(BitmapUtils.decodeSampleBitmap(getBaseActivity(), (String)localObject1, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight()), (String)localObject1);
    Object localObject2 = new ImageView(getBaseActivity());
    ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
    paramViewGroup.addView((View)localObject2);
    if (localObject1 != null)
    {
      paramInt = ((Bitmap)localObject1).getWidth();
      int i = ((Bitmap)localObject1).getHeight();
      float f = paramInt / i;
      paramInt = this.mCenterViewWidth;
      if (f < paramInt / paramInt)
      {
        i = (int)(paramInt / f);
      }
      else
      {
        i = this.mCenterViewHeight;
        paramInt = (int)(i * f);
      }
      ((ImageView)localObject2).measure(View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
      int j = this.mCenterViewWidth;
      int k = (j - paramInt) / 2;
      int m = this.mCenterViewHeight;
      ((ImageView)localObject2).layout(k, (m - i) / 2, (j + paramInt) / 2, (m + i) / 2);
    }
    localObject1 = this.mImageViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ScaleMoveImageViewer)((Iterator)localObject1).next();
      if ((((ScaleMoveImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject2).getNode().zIndex >= 10000))
      {
        paramViewGroup.addView((View)localObject2);
        imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
      }
    }
    localObject1 = this.mTextViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditTextViewer)((Iterator)localObject1).next();
      if ((((EditTextViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject2).getNode().zIndex >= 10000))
      {
        paramViewGroup.addView((View)localObject2);
        imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
      }
    }
    localObject1 = this.mFaceImageViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FaceImageViewer)((Iterator)localObject1).next();
      if ((((FaceImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject2).getNode().zIndex >= 10000))
      {
        paramViewGroup.addView((View)localObject2);
        imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
      }
    }
  }
  
  private void showLoading(String paramString)
  {
    Object localObject = getBaseActivity();
    if ((localObject != null) && (!((BaseActivity)localObject).isFinishing()))
    {
      if (this.mLoadingDialog == null)
      {
        this.mLoadingDialog = new Dialog((Context)localObject, 2131953338);
        this.mLoadingDialog.setCancelable(false);
        this.mLoadingDialog.setCanceledOnTouchOutside(false);
        this.mLoadingDialog.setContentView(2131625585);
      }
      localObject = (TextView)this.mLoadingDialog.findViewById(2131440191);
      if (!TextUtils.isEmpty(paramString)) {
        ((TextView)localObject).setText(paramString);
      } else {
        ((TextView)localObject).setText(2131892582);
      }
      this.mLoadingDialog.show();
    }
  }
  
  private void showProgressDialog()
  {
    Dialog localDialog = this.mDialog;
    if (localDialog != null) {
      localDialog.show();
    }
  }
  
  private void startVideoTemplateSaveActivity(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Log.i("AEVideoShelfEditFrag", "已经合成完视频，不进行实时预览。");
      AEQLog.b("AEVideoShelfEditFrag", "已经合成完视频，不进行实时预览。");
      if (this.mTemplate != null)
      {
        if (this.mFinalVideoPath == null) {
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("from", true);
        localIntent.putExtra("MaterialId", this.mMaterialId);
        localIntent.putExtra("FinalVideoPath", this.mFinalVideoPath);
        localIntent.putExtra("usePagPreview", paramBoolean);
        localIntent.putExtra("MaterialPath", this.mTemplatePath);
        localIntent.putExtra("MaterialName", this.mTemplate.getVideoName());
        localIntent.putStringArrayListExtra("PhotoList", this.mSourcePhotoList);
        localIntent.putExtra("loc_play_show_tab_name", this.playShowTabName);
        localIntent.putExtra("loc_play_show_material_id", this.mMaterialId);
        localIntent.putExtra("loc_play_show_take_same_name", this.mTakeSameName);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.getFromType(getBaseActivity()));
        localIntent.putExtra("isNeedEditButton", true);
        checkJumpToPreview(localIntent);
        this.mIsSavingVideo = Boolean.valueOf(false);
        return;
      }
      return;
    }
    jumpToPagRealtimePreview();
  }
  
  private void updateProgress(int paramInt)
  {
    ProgressPieDrawable localProgressPieDrawable = this.ppd;
    if (localProgressPieDrawable == null) {
      return;
    }
    localProgressPieDrawable.b();
    this.ppd.d(paramInt);
    this.ppd.b(true);
    this.ppd.d(false);
    localProgressPieDrawable = this.ppd;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    localProgressPieDrawable.a(localStringBuilder.toString());
  }
  
  private void updateRVListItem(int paramInt)
  {
    this.mBoxRecycleView.postDelayed(new AEVideoShelfEditFragment.19(this, paramInt), 100L);
  }
  
  public void hideDownloadDialog()
  {
    hideLoading();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    getBaseActivity().finish();
  }
  
  public void onCancelCompleted()
  {
    AEQLog.b("AEVideoShelfEditFrag", "Merge Video step onCancelCompleted");
    this.mGenerateBegin = 0L;
    UiThreadUtil.a(new AEVideoShelfEditFragment.18(this));
  }
  
  public void onClick(View paramView)
  {
    if (AEFastClickThrottle.a(paramView)) {
      return;
    }
    int i = paramView.getId();
    if (i == 2063990900)
    {
      onBackPressed();
      return;
    }
    if (i == 2063990925)
    {
      goNext();
      AEBaseDataReporter.a().o();
      return;
    }
    if (i == 2063991023) {
      onFirstImageViewClick(paramView);
    }
  }
  
  public void onCompleteTextEdit(NodeItem paramNodeItem)
  {
    updateRVListItem(paramNodeItem.nodeGroupID);
  }
  
  public void onCompleted()
  {
    AEQLog.b("AEVideoShelfEditFrag", "Merge Video step onCompleted");
    long l;
    if (this.mGenerateBegin > 0L) {
      l = System.currentTimeMillis() - this.mGenerateBegin;
    } else {
      l = 0L;
    }
    this.mGenerateBegin = 0L;
    finishAudioVideoMerge();
    UiThreadUtil.a(new AEVideoShelfEditFragment.15(this, l));
    startVideoTemplateSaveActivity(false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064056364, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    Object localObject1 = this.mBoxRecycleView;
    if (localObject1 != null) {
      ((RecyclerView)localObject1).setAdapter(null);
    }
    localObject1 = this.mVideoListAdapter;
    if (localObject1 != null) {
      ((VideoListAdapter)localObject1).clearBitmaps();
    }
    this.mVideoListAdapter = null;
    localObject1 = this.mBackgroundBitmap;
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
      this.mBackgroundBitmap.recycle();
    }
    localObject1 = this.mButtonCancel;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener(null);
    }
    localObject1 = this.mButtonOk;
    if (localObject1 != null) {
      ((TextView)localObject1).setOnClickListener(null);
    }
    localObject1 = this.mButtonChangeImage;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener(null);
    }
    localObject1 = this.mBitmaps.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Bitmap)((Iterator)localObject1).next();
      if (BitmapUtils.isLegal((Bitmap)localObject2)) {
        ((Bitmap)localObject2).recycle();
      }
    }
    localObject1 = this.mSourceBitmaps.entrySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      BitmapUtils.recycle((Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue());
    }
    this.mSourceBitmaps.clear();
    localObject1 = this.mImageViewerSet.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ScaleMoveImageViewer)((Iterator)localObject1).next()).clearBitmaps();
    }
    localObject1 = this.mTextViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditTextViewer)((Iterator)localObject1).next();
      ((EditTextViewer)localObject2).clearBitmaps();
      ((EditTextViewer)localObject2).setOnDownloadDialogListener(null);
    }
    localObject1 = this.mFaceImageViewerSet.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((FaceImageViewer)((Iterator)localObject1).next()).clearBitmaps();
    }
    dismissProgressDialog();
    keepScreenOn(getBaseActivity(), false);
    super.onDestroy();
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    this.mGenerateBegin = 0L;
    UiThreadUtil.a(new AEVideoShelfEditFragment.17(this));
    AEQLog.c("AEVideoShelfEditFrag", "Merge Video step onError");
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent == null) {
      return;
    }
    if (paramIntent.getIntExtra("pic_result_back_type", -1) == 1)
    {
      String str = paramIntent.getStringExtra("PhotoConst.SELECTED_PATHS");
      int i = paramIntent.getIntExtra("pic_choose_in_node_id", 0);
      paramIntent = findNodeItemById((NodeGroup)this.mNodeGroupList.get(this.mPrePos), i);
      if (paramIntent == null) {
        return;
      }
      if (paramIntent.type == 0) {
        onImageChanged(i, str);
      } else if (paramIntent.type == 2) {
        onFaceImageChanged(i, str, true);
      }
      if ((!TextUtils.isEmpty(str)) && (this.mNodeSourceMap.indexOfKey(i) >= 0))
      {
        i = this.mNodeSourceMap.get(i);
        paramIntent = this.mSourcePhotoList;
        if ((paramIntent != null) && (i >= 0) && (i < paramIntent.size()))
        {
          this.mSourcePhotoList.remove(i);
          this.mSourcePhotoList.add(i, str);
        }
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mIsSavingVideo.booleanValue()) {
      this.mEngine.cancelSave();
    }
  }
  
  public void onProgress(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.mLastUpdateProgressTimeMs > 200L)
    {
      UiThreadUtil.a(new AEVideoShelfEditFragment.14(this, paramInt));
      this.mLastUpdateProgressTimeMs = l;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.mImageViewerSet.iterator();
    while (localIterator.hasNext()) {
      ((ScaleMoveImageViewer)localIterator.next()).clearSeclected();
    }
    localIterator = this.mTextViewerSet.iterator();
    while (localIterator.hasNext()) {
      EditTextViewer localEditTextViewer = (EditTextViewer)localIterator.next();
    }
    localIterator = this.mFaceImageViewerSet.iterator();
    while (localIterator.hasNext()) {
      ((FaceImageViewer)localIterator.next()).clearSeclected();
    }
    clearTempFiles();
  }
  
  public void onSaveScrollInfo(NodeItem paramNodeItem)
  {
    NodeGroup localNodeGroup = new NodeGroup();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.mNodeGroupList.size()) {
        break;
      }
      if (paramNodeItem.nodeGroupID == ((NodeGroup)this.mNodeGroupList.get(i)).nodeGroupID) {
        localNodeGroup = (NodeGroup)this.mNodeGroupList.get(i);
      }
      i += 1;
    }
    while (j < localNodeGroup.nodeItemList.size())
    {
      if (paramNodeItem.nodeID == ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeID)
      {
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).once = paramNodeItem.once;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).matrix.set(paramNodeItem.matrix);
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).bitmap = paramNodeItem.bitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).cropBitmap = paramNodeItem.cropBitmap;
      }
      j += 1;
    }
  }
  
  public void onSaveTextInfo(NodeItem paramNodeItem)
  {
    NodeGroup localNodeGroup = new NodeGroup();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.mNodeGroupList.size()) {
        break;
      }
      if (paramNodeItem.nodeGroupID == ((NodeGroup)this.mNodeGroupList.get(i)).nodeGroupID) {
        localNodeGroup = (NodeGroup)this.mNodeGroupList.get(i);
      }
      i += 1;
    }
    while (j < localNodeGroup.nodeItemList.size())
    {
      if (paramNodeItem.nodeID == ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeID)
      {
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).once = paramNodeItem.once;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).bitmap = paramNodeItem.bitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).cropBitmap = paramNodeItem.cropBitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeTextMaxCount = paramNodeItem.nodeTextMaxCount;
      }
      j += 1;
    }
  }
  
  public void onStartGenerate()
  {
    AEQLog.b("AEVideoShelfEditFrag", "Merge Video step onStartGenerate");
    this.mGenerateBegin = System.currentTimeMillis();
    UiThreadUtil.a(new AEVideoShelfEditFragment.13(this));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    initData();
    initView();
    initSoftInputMode();
    this.outputDir = AEPath.PLAY.CACHE.c;
    paramView = new File(this.outputDir);
    if (!paramView.exists()) {
      paramView.mkdirs();
    }
  }
  
  public void showDownloadDialog()
  {
    showLoading(getResources().getString(2064187594));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment
 * JD-Core Version:    0.7.0.1
 */