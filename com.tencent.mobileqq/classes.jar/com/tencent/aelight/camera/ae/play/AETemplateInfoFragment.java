package com.tencent.aelight.camera.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.ae.AEPath.PLAY.CACHE;
import com.tencent.aelight.camera.ae.entry.AECameraLauncher;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.ae.util.PicChooseJumpUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeGroup;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import com.tencent.ttpic.videoshelf.parser.TemplateParser;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.light.device.OfflineConfig;

public class AETemplateInfoFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, PublicFragmentActivityCallBackInterface
{
  public static final String CACHE_DIR = AEPath.PLAY.CACHE.b;
  public static final String PREFERENCE_K_QUDONG_LAST_CRAZY_FACE_PHOTO = "ae_preference_k_qudong_last_crazy_face_photo";
  public static final int REQUEST_CODE_TAKE_FACE_PHOTO = 1024;
  private static final String TAG = "AETemplateInfoFragment";
  private List<String> crazyFaceMaterials;
  private boolean isCrazyFace;
  private ArrayList<String> mCropPhotoCacheList = new ArrayList();
  private boolean mHasTextNode = false;
  private boolean mIsEnglish = false;
  private boolean mIsSimpleChinese = true;
  private ImageView mLastImg;
  private ViewGroup mLastLayout;
  private Bitmap mLastPhoto;
  private String mLastPhotoPath;
  private Dialog mLoadingDialog;
  private String mMaterialId;
  private String mMaterialName;
  private String mMaterialPath;
  private boolean mNeedPlayVideo = true;
  private TextView mNextButton;
  private List<NodeGroup> mNodeGroupList = new ArrayList();
  private FrameLayout mPlayerContainer;
  private AETemplateInfoFragment.PlayerListener mPlayerListener;
  private TextView mPlayerRateView;
  private ArrayList<String> mSelectedPhotoList;
  private boolean mSurfaceReady = false;
  private String mTakeSameName;
  private VideoShelfTemplate mTemplate;
  private TextView mTipsTextView;
  private TextView mTitleTextView;
  private IVideoShelfPlayer mVideoPlayer;
  private int mVideoPosition;
  private TextureView mVideoView;
  private String playShowTabName = "";
  private ImageView playerStatusView;
  private int screenHeight;
  private int screenWidth;
  private Dialog tipDialog;
  
  static
  {
    File localFile = new File(CACHE_DIR);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private String buildTips(VideoShelfTemplate paramVideoShelfTemplate)
  {
    Object localObject3 = "";
    if (paramVideoShelfTemplate == null) {
      return "";
    }
    Object localObject1 = paramVideoShelfTemplate.getTipTemplate();
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return "";
      }
      int i = 0;
      int j = localObject1[0];
      if (getResources() != null) {
        paramVideoShelfTemplate = String.format("需选择%d张图片", new Object[] { Integer.valueOf(j) });
      } else {
        paramVideoShelfTemplate = "";
      }
      if (j == 0) {
        paramVideoShelfTemplate = "";
      }
      if (localObject1.length > 1) {
        i = localObject1[1];
      }
      if (i > 0) {
        localObject1 = "可修改文字";
      } else {
        localObject1 = "";
      }
      Object localObject2 = localObject3;
      if (!TextUtils.isEmpty(paramVideoShelfTemplate))
      {
        localObject2 = localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject3;
          if (this.mIsEnglish) {
            localObject2 = " ";
          }
        }
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramVideoShelfTemplate);
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append((String)localObject1);
      return ((StringBuilder)localObject3).toString();
    }
    return "";
  }
  
  private void cancelTipDialog()
  {
    Dialog localDialog = this.tipDialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
  }
  
  private void changeFace(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.crazyFaceMaterials;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        localObject = BitmapUtils.decodeSampleBitmap(getBaseActivity(), paramString, this.screenWidth, this.screenHeight);
        if (localObject == null) {
          return;
        }
        AECameraPrefsUtil.a().a("ae_preference_k_qudong_last_crazy_face_photo", paramString, 0);
        showLoading(true);
        long l = System.currentTimeMillis();
        this.mNeedPlayVideo = false;
        pauseVideo();
        FaceChangeUtils.change((Bitmap)localObject, this.crazyFaceMaterials, new AETemplateInfoFragment.5(this, paramString, (Bitmap)localObject, l));
      }
    }
  }
  
  private String cropHeadOfImage(String paramString)
  {
    Object localObject1 = new File(paramString);
    Object localObject2 = new File(AEPath.PLAY.CACHE.a);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((File)localObject2).getPath());
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("crop_");
    ((StringBuilder)localObject3).append(((File)localObject1).getName());
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject1 = BitmapUtils.decodeSampleBitmap(getBaseActivity(), paramString, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
    if (!BitmapUtils.isLegal((Bitmap)localObject1)) {
      return paramString;
    }
    localObject2 = VideoShelfBitmapUtils.rotateWithExif((Bitmap)localObject1, paramString);
    localObject1 = localObject2;
    if (((Bitmap)localObject2).getWidth() == 1)
    {
      localObject1 = localObject2;
      if (((Bitmap)localObject2).getHeight() == 1) {
        localObject1 = BitmapUtils.scaleBitmap((Bitmap)localObject2, 2.0F, true);
      }
    }
    localObject2 = new boolean[1];
    localObject2[0] = 0;
    FaceChangeUtils.cropFace((Bitmap)localObject1, new AETemplateInfoFragment.4(this, (boolean[])localObject2, (String)localObject3), true);
    if (localObject2[0] != 0) {
      return localObject3;
    }
    return paramString;
  }
  
  public static int dp2px(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int getFromType(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return ((Activity)paramContext).getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    }
    return AECameraEntry.a.a();
  }
  
  private void initData()
  {
    this.screenWidth = DisplayUtil.a(getBaseActivity());
    this.screenHeight = DisplayUtil.b(getBaseActivity());
    Object localObject = getBaseActivity().getIntent();
    if (localObject != null)
    {
      this.mMaterialPath = ((Intent)localObject).getStringExtra("MaterialPath");
      this.mMaterialId = ((Intent)localObject).getStringExtra("MaterialId");
      this.mMaterialName = ((Intent)localObject).getStringExtra("MaterialName");
      this.playShowTabName = ((Intent)localObject).getStringExtra("loc_play_show_tab_name");
      this.mTakeSameName = ((Intent)localObject).getStringExtra("loc_play_show_take_same_name");
    }
    if ((this.mTemplate == null) && (!TextUtils.isEmpty(this.mMaterialPath))) {
      loadTemplate(this.mMaterialPath);
    }
    localObject = this.mTemplate;
    if (localObject != null)
    {
      this.crazyFaceMaterials = ((VideoShelfTemplate)localObject).getCrazyFaceList();
      localObject = this.crazyFaceMaterials;
      boolean bool;
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
      this.isCrazyFace = bool;
    }
    if (this.isCrazyFace)
    {
      this.mLastPhotoPath = AECameraPrefsUtil.a().a("ae_preference_k_qudong_last_crazy_face_photo", null, 0);
      if (!TextUtils.isEmpty(this.mLastPhotoPath))
      {
        int i = getBaseActivity().getResources().getDimensionPixelSize(2063990888);
        int j = getBaseActivity().getResources().getDimensionPixelSize(2063990889);
        this.mLastPhoto = BitmapUtils.decodeSampleBitmap(getBaseActivity(), this.mLastPhotoPath, j, i);
      }
    }
    OfflineFileUpdater.setHttpClient(new UrlConHttpClient());
    OfflineFileUpdater.checkOfflineFile();
  }
  
  private void initNodeGroup()
  {
    if (this.mTemplate == null) {
      return;
    }
    int i = 0;
    while (i < this.mTemplate.getNodeGroupList().size())
    {
      Object localObject = (MaskNodeGroup)this.mTemplate.getNodeGroupList().get(i);
      NodeGroup localNodeGroup = new NodeGroup();
      localNodeGroup.nodeGroupID = ((MaskNodeGroup)localObject).getNodeGroupID();
      localObject = ((MaskNodeGroup)localObject).getNodeList();
      localNodeGroup.nodeItemList = new ArrayList();
      int j = 0;
      while (j < ((List)localObject).size())
      {
        MaskNodeItem localMaskNodeItem = (MaskNodeItem)((List)localObject).get(j);
        NodeItem localNodeItem = new NodeItem();
        localNodeItem.nodeID = localMaskNodeItem.getNodeID();
        localNodeItem.type = localMaskNodeItem.getType();
        localNodeItem.nodeGroupID = localMaskNodeItem.getNodeGroupID();
        localNodeItem.zIndex = localMaskNodeItem.getZIndex();
        localNodeItem.indexLayerForPag = localMaskNodeItem.getIndexLayerForPag();
        localNodeGroup.nodeItemList.add(localNodeItem);
        j += 1;
      }
      this.mNodeGroupList.add(localNodeGroup);
      i += 1;
    }
  }
  
  private void initView()
  {
    View localView = getView();
    this.mNextButton = ((TextView)localView.findViewById(2064122453));
    this.mLastImg = ((ImageView)localView.findViewById(2064122263));
    this.mLastLayout = ((ViewGroup)localView.findViewById(2064122340));
    this.mNextButton.setOnClickListener(this);
    this.mLastLayout.setOnClickListener(this);
    this.mTitleTextView = ((TextView)localView.findViewById(2064122709));
    this.mTipsTextView = ((TextView)localView.findViewById(2064122708));
    this.mPlayerRateView = ((TextView)localView.findViewById(2064122505));
    if (isDebugVersion())
    {
      this.mPlayerRateView.setVisibility(0);
      this.mPlayerRateView.setText("0(fps)");
      this.mPlayerRateView.setTextColor(-65536);
    }
    this.playerStatusView = ((ImageView)localView.findViewById(2064122506));
    this.mVideoView = ((TextureView)localView.findViewById(2064122510));
    this.mVideoView.setKeepScreenOn(true);
    this.mPlayerContainer = ((FrameLayout)localView.findViewById(2064122504));
    this.mPlayerContainer.getViewTreeObserver().addOnGlobalLayoutListener(new AETemplateInfoFragment.1(this));
    this.mVideoView.setOnClickListener(this);
    this.mVideoView.setSurfaceTextureListener(new AETemplateInfoFragment.PlayerSurfaceTextureCallback(this));
    this.mPlayerListener = new AETemplateInfoFragment.PlayerListener(this);
    if (this.isCrazyFace)
    {
      if (this.mLastPhoto != null)
      {
        this.mLastLayout.setVisibility(0);
        this.mLastImg.setImageBitmap(this.mLastPhoto);
        this.mNextButton.setTextColor(-16777216);
        this.mNextButton.setBackgroundResource(2064056398);
        this.mNextButton.setText(2064515245);
        this.mTipsTextView.setVisibility(8);
        return;
      }
      this.mTipsTextView.setText(2064515242);
      this.mTipsTextView.setVisibility(0);
    }
  }
  
  private boolean isDebugVersion()
  {
    return false;
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
  
  private void jumpToEdit()
  {
    if (this.mTemplate == null) {
      return;
    }
    AEVideoShelfEditFragment.jumpToMe(getBaseActivity(), this.playShowTabName, this.mTemplate.getMaterialPath(), this.mMaterialId, this.mTemplate.getVideoName(), this.mSelectedPhotoList, 1, this.mTakeSameName);
  }
  
  public static void jumpToMe(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString2);
    localIntent.putExtra("MaterialId", paramString3);
    localIntent.putExtra("MaterialName", paramString4);
    localIntent.putExtra("loc_play_show_tab_name", paramString1);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", getFromType(paramContext));
    localIntent.putExtra("loc_play_show_take_same_name", paramString5);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivityForPeak.class, AETemplateInfoFragment.class);
  }
  
  private void jumpToPagRealtimePreview(boolean paramBoolean)
  {
    Log.i("AETemplateInfoFragment", "未合成视频，将直接实时预览。");
    AEQLog.b("AETemplateInfoFragment", "未合成视频，将直接实时预览。");
    if (this.mTemplate == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("from", true);
    localIntent.putExtra("isNeedEditButton", paramBoolean ^ true);
    localIntent.putExtra("usePagPreview", true);
    localIntent.putExtra("videoOutWidth", this.mTemplate.getVideoWidth());
    localIntent.putExtra("videoOutHeight", this.mTemplate.getVideoHeight());
    localIntent.putExtra("pagFilePath", this.mTemplate.getPagFilePath());
    localIntent.putExtra("audioFilePath", this.mTemplate.getAudioPath());
    localIntent.putExtra("MaterialPath", this.mTemplate.getMaterialPath());
    localIntent.putExtra("MaterialName", this.mTemplate.getVideoName());
    localIntent.putExtra("loc_play_show_tab_name", this.playShowTabName);
    localIntent.putExtra("loc_play_show_material_id", this.mMaterialId);
    localIntent.putExtra("loc_play_show_take_same_name", this.mTakeSameName);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", getFromType(getBaseActivity()));
    localIntent.putStringArrayListExtra("PhotoList", this.mSelectedPhotoList);
    localIntent.putExtra("MaterialId", this.mMaterialId);
    initNodeGroup();
    HashMap localHashMap = new HashMap();
    int i = 0;
    Iterator localIterator1 = this.mNodeGroupList.iterator();
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((NodeGroup)localIterator1.next()).nodeItemList.iterator();
      int j = i;
      for (;;)
      {
        i = j;
        if (!localIterator2.hasNext()) {
          break;
        }
        NodeItem localNodeItem = (NodeItem)localIterator2.next();
        localObject = this.mSelectedPhotoList;
        if ((localObject != null) && (j < ((ArrayList)localObject).size()))
        {
          localObject = (String)this.mSelectedPhotoList.get(j);
          if (localNodeItem.type == 2)
          {
            localObject = cropHeadOfImage((String)this.mSelectedPhotoList.get(j));
            this.mCropPhotoCacheList.add(localObject);
          }
          localHashMap.put(localObject, localNodeItem.indexLayerForPag);
          j += 1;
        }
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putSerializable("nodeImgList", localHashMap);
    localIntent.putExtras((Bundle)localObject);
    AEVideoShelfPreviewFragment.jumpToMe(getBaseActivity(), localIntent, 1);
  }
  
  private void loadTemplate(String paramString)
  {
    try
    {
      if (this.mTemplate != null) {
        break label28;
      }
      this.mTemplate = TemplateParser.parse(getBaseActivity(), paramString);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      label20:
      label28:
      break label20;
    }
    AEQLog.c("AETemplateInfoFragment", "loadTemplate Error!");
  }
  
  private void onNext()
  {
    VideoShelfTemplate localVideoShelfTemplate = this.mTemplate;
    if ((localVideoShelfTemplate != null) && (!TextUtils.isEmpty(localVideoShelfTemplate.getMaterialPath())))
    {
      if (this.isCrazyFace)
      {
        startTakeFacePhotoNext();
        return;
      }
      int i1 = 0;
      int k = 0;
      int j = 0;
      int m;
      for (int i = 0; k < this.mTemplate.getNodeGroupList().size(); i = m)
      {
        int n = j;
        m = i;
        if (this.mTemplate.getNodeGroupList().get(k) != null)
        {
          n = j;
          m = i;
          if (((MaskNodeGroup)this.mTemplate.getNodeGroupList().get(k)).getNodeList() != null)
          {
            m = 0;
            while (m < ((MaskNodeGroup)this.mTemplate.getNodeGroupList().get(k)).getNodeList().size())
            {
              if (((MaskNodeItem)((MaskNodeGroup)this.mTemplate.getNodeGroupList().get(k)).getNodeList().get(m)).getType() != 1) {
                i += 1;
              } else {
                j += 1;
              }
              m += 1;
            }
            m = i;
            n = j;
          }
        }
        k += 1;
        j = n;
      }
      boolean bool;
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.mHasTextNode = bool;
      k = i1;
      if (j > 0)
      {
        k = i1;
        if (i == 0) {
          k = 1;
        }
      }
      if (k != 0)
      {
        jumpToEdit();
        return;
      }
      startAlumNext(i);
      return;
    }
    AEQLog.c("AETemplateInfoFragment", "onNext template Error!");
  }
  
  private void onPlayError()
  {
    AEQLog.c("AETemplateInfoFragment", "onPlayError!");
  }
  
  private void pauseVideo()
  {
    IVideoShelfPlayer localIVideoShelfPlayer = this.mVideoPlayer;
    if (localIVideoShelfPlayer != null)
    {
      if (localIVideoShelfPlayer.isPlaying())
      {
        this.mVideoPlayer.pause();
        QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo done");
        videoViewStatusPause();
        return;
      }
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo enter, mVideoPlayer is not playing");
      return;
    }
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo enter, mVideoPlayer is null");
  }
  
  private void playVideo()
  {
    if (this.mTemplate != null)
    {
      Object localObject = this.mVideoPlayer;
      if (localObject == null) {
        return;
      }
      ((IVideoShelfPlayer)localObject).reset();
      this.mVideoPlayer.setVideoShelfPlayerListener(this.mPlayerListener);
      localObject = this.mTemplate.getPreviewVideoPath();
      String str = null;
      if ((this.mVideoPlayer instanceof PagShelfPlayer))
      {
        localObject = this.mTemplate.getPagFilePath();
        str = this.mTemplate.getAudioPath();
      }
      if (this.mTemplate.isFromAssets())
      {
        this.mVideoPlayer.setDataSource(getBaseActivity().getAssets(), (String)localObject);
        if ((str != null) && (FileUtils.exists(str))) {
          this.mVideoPlayer.setParam("pagShelfPlayerAudioFilePath", new Object[] { Boolean.valueOf(true), getBaseActivity().getAssets(), str });
        }
      }
      else
      {
        this.mVideoPlayer.setDataSource((String)localObject);
        if ((str != null) && (FileUtils.exists(str))) {
          this.mVideoPlayer.setParam("pagShelfPlayerAudioFilePath", new Object[] { Boolean.valueOf(false), str });
        }
      }
      this.mVideoPlayer.prepare();
      this.mVideoPlayer.seekTo(this.mVideoPosition);
      if (this.mNeedPlayVideo)
      {
        this.mVideoPlayer.start();
        QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---mVideoPlayer.start() in playVideo");
      }
    }
  }
  
  private void popNotSupportPagToast(String paramString) {}
  
  private void previewTemplate()
  {
    if (this.mTemplate != null)
    {
      showTemplate();
      playVideo();
    }
  }
  
  private void resumeVideoToStart()
  {
    if (this.mVideoPlayer != null) {
      onPlayComplete();
    }
  }
  
  public static void sendPickedPhotosToMe(Context paramContext, Intent paramIntent)
  {
    paramIntent.addFlags(67108864);
    paramIntent.addFlags(536870912);
    paramIntent.putExtra("VIDEO_STORY_FROM_TYPE", getFromType(paramContext));
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, PublicFragmentActivityForPeak.class, AETemplateInfoFragment.class);
  }
  
  private void showFirstEntryTipDialog()
  {
    Object localObject = this.tipDialog;
    if (localObject != null)
    {
      if (((Dialog)localObject).isShowing()) {
        this.tipDialog.dismiss();
      }
    }
    else
    {
      this.tipDialog = new Dialog(getBaseActivity(), 2131756189);
      this.tipDialog.setCancelable(true);
      this.tipDialog.setCanceledOnTouchOutside(true);
      this.tipDialog.setContentView(2064318514);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getActivity().getResources().getDrawable(2131167394);
      localObject = URLDrawable.getDrawable("https://dl.url.cn/myapp/qq_desk/qqrm/videofilter/Pturenwu/tipss.png", (URLDrawable.URLDrawableOptions)localObject);
      URLImageView localURLImageView = (URLImageView)this.tipDialog.findViewById(2064122283);
      TextView localTextView = (TextView)this.tipDialog.findViewById(2064122740);
      localURLImageView.setImageDrawable((Drawable)localObject);
      this.tipDialog.show();
      localTextView.setOnClickListener(new AETemplateInfoFragment.3(this));
    }
    if (!this.tipDialog.isShowing()) {
      this.tipDialog.show();
    }
  }
  
  private void showLoading(boolean paramBoolean)
  {
    Object localObject = getBaseActivity();
    if ((localObject != null) && (!((BaseActivity)localObject).isFinishing()))
    {
      if (paramBoolean)
      {
        if (this.mLoadingDialog == null)
        {
          this.mLoadingDialog = new Dialog((Context)localObject, 2131756189);
          this.mLoadingDialog.setCancelable(false);
          this.mLoadingDialog.setCanceledOnTouchOutside(false);
          this.mLoadingDialog.setContentView(2131559561);
        }
        this.mLoadingDialog.show();
        return;
      }
      localObject = this.mLoadingDialog;
      if ((localObject != null) && (((Dialog)localObject).isShowing())) {
        this.mLoadingDialog.dismiss();
      }
    }
  }
  
  private void showTemplate()
  {
    if (this.mIsSimpleChinese)
    {
      this.mTitleTextView.setText(this.mTemplate.getName());
      this.mTipsTextView.setText(this.mTemplate.getTip());
      return;
    }
    this.mTitleTextView.setText(this.mMaterialName);
    getBaseActivity().findViewById(2131365519).setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTipsTextView.getLayoutParams();
    this.mTipsTextView.setLines(2);
    localLayoutParams.height = ((int)(this.mTipsTextView.getContext().getResources().getDisplayMetrics().density * 32.0F));
    this.mTipsTextView.setLayoutParams(localLayoutParams);
    this.mTipsTextView.setText(buildTips(this.mTemplate));
  }
  
  private void startAlumNext(int paramInt)
  {
    PicChooseJumpUtil.a(getBaseActivity(), paramInt);
  }
  
  private void startPreviewNext()
  {
    showLoading(true);
    jumpToPagRealtimePreview(false);
    showLoading(false);
  }
  
  private void startTakeFacePhotoNext()
  {
    if (!isNeedRealTimePlay())
    {
      QQToast.a(getBaseActivity(), getBaseActivity().getString(2064515235), 0).a();
      return;
    }
    if (AECameraPrefsUtil.a().a("key_first_change_face_click_flag", true, 0))
    {
      AECameraPrefsUtil.a().a("key_first_change_face_click_flag", false, 0);
      showFirstEntryTipDialog();
      return;
    }
    AECameraLauncher.a(getBaseActivity(), 1024, AECameraEntry.K.a(), null);
  }
  
  private void stopVideo()
  {
    IVideoShelfPlayer localIVideoShelfPlayer = this.mVideoPlayer;
    if (localIVideoShelfPlayer != null)
    {
      if (localIVideoShelfPlayer.isPlaying())
      {
        this.mVideoPlayer.stop();
        QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo done");
      }
      else
      {
        QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo enter, mVideoPlayer is not playing");
      }
      try
      {
        this.mVideoPlayer.setSurface(null);
      }
      catch (Exception localException)
      {
        AEQLog.a("AETemplateInfoFragment", "mVideoPlayer.setSurface(null) raise exception: ", localException);
      }
      this.mVideoPosition = this.mVideoPlayer.getCurrentPosition();
      videoViewStatusPause();
      this.mNeedPlayVideo = false;
      this.mVideoPlayer = null;
      return;
    }
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo enter, mVideoPlayer is null");
  }
  
  private void surfaceTextureAvailable(SurfaceTexture paramSurfaceTexture)
  {
    int j = 1;
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---surfaceTextureAvailable");
    this.mSurfaceReady = true;
    if ((this.mTemplate == null) && (!TextUtils.isEmpty(this.mMaterialPath))) {
      loadTemplate(this.mMaterialPath);
    }
    for (;;)
    {
      try
      {
        if (this.mVideoPlayer == null)
        {
          if ((this.mTemplate != null) && (this.mTemplate.getVersion() == 1))
          {
            i = j;
            if (this.mTemplate.getPreviewVideoPath() != null)
            {
              if (FileUtils.exists(this.mTemplate.getPreviewVideoPath())) {
                break label167;
              }
              i = j;
            }
            Object localObject;
            if (i != 0) {
              localObject = new PagShelfPlayer();
            } else {
              localObject = new VideoShelfPlayer();
            }
            this.mVideoPlayer = ((IVideoShelfPlayer)localObject);
          }
        }
        else
        {
          this.mVideoPlayer.setSurface(new Surface(paramSurfaceTexture));
          previewTemplate();
          return;
        }
      }
      catch (PagNotSupportSystemException paramSurfaceTexture)
      {
        AEQLog.d("AETemplateInfoFragment", paramSurfaceTexture.getMessage());
        popNotSupportPagToast("pag版本过低");
        return;
      }
      label167:
      int i = 0;
    }
  }
  
  private void surfaceTextureDestroyed()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---surfaceTextureDestroyed");
    this.mSurfaceReady = false;
    stopVideo();
  }
  
  private void toastInUIThread(String paramString)
  {
    getBaseActivity().runOnUiThread(new AETemplateInfoFragment.6(this, paramString));
  }
  
  private void toggleVideoStatus()
  {
    IVideoShelfPlayer localIVideoShelfPlayer = this.mVideoPlayer;
    if (localIVideoShelfPlayer != null)
    {
      if (localIVideoShelfPlayer.isPlaying())
      {
        this.mVideoPlayer.pause();
        videoViewStatusPause();
        return;
      }
      this.mNeedPlayVideo = true;
      this.mVideoPlayer.start();
      videoViewStatusPlay();
    }
  }
  
  private void videoViewStatusPause()
  {
    this.playerStatusView.setVisibility(0);
  }
  
  private void videoViewStatusPlay()
  {
    this.playerStatusView.setVisibility(8);
  }
  
  protected int getContentLayoutId()
  {
    return 2064318498;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1024) && (paramInt2 == -1)) {
      changeFace(paramIntent.getExtras().getString("take_photo_path"));
    }
  }
  
  public void onBackPressed()
  {
    getBaseActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    if (AEFastClickThrottle.a(paramView)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364166: 
      onBackPressed();
      return;
    case 2064122510: 
      toggleVideoStatus();
      return;
    case 2064122453: 
      onNext();
      if (!this.isCrazyFace)
      {
        AEBaseDataReporter.a().R();
        return;
      }
      AEBaseDataReporter.a().S();
      return;
    }
    changeFace(this.mLastPhotoPath);
    AEBaseDataReporter.a().T();
  }
  
  public void onDestroy()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onDestroy");
    stopVideo();
    super.onDestroy();
    cancelTipDialog();
    BitmapUtils.recycle(this.mLastPhoto);
    Iterator localIterator = this.mCropPhotoCacheList.iterator();
    while (localIterator.hasNext()) {
      FileUtils.delete((String)localIterator.next());
    }
    if (QLog.isDebugVersion()) {
      QLog.d("AETemplateInfoFragment", 4, "submit clear temp files task");
    }
    ThreadManagerV2.excute(new AETemplateInfoFragment.2(this), 64, null, false);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent == null) {
      return;
    }
    if (paramIntent.getIntExtra("pic_result_back_type", -1) == 0)
    {
      this.mSelectedPhotoList = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if ((isNeedRealTimePlay()) && (!this.mHasTextNode))
      {
        startPreviewNext();
        return;
      }
      jumpToEdit();
    }
  }
  
  public void onPause()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onPause");
    super.onPause();
    this.mNeedPlayVideo = false;
    pauseVideo();
  }
  
  public void onPlayComplete()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onPlayComplete");
    IVideoShelfPlayer localIVideoShelfPlayer = this.mVideoPlayer;
    if (localIVideoShelfPlayer != null) {
      localIVideoShelfPlayer.seekTo(0);
    }
    videoViewStatusPause();
    this.mNeedPlayVideo = false;
    if (isDebugVersion()) {
      this.mPlayerRateView.setText("0(fps)");
    }
  }
  
  public void onResume()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onResume");
    super.onResume();
    resumeVideoToStart();
  }
  
  public void onUpdateRate(long paramLong)
  {
    if (isDebugVersion())
    {
      TextView localTextView = this.mPlayerRateView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("(fps)");
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.vg.setTitle("模板详情");
    if (!FeatureManager.Features.PAG.init())
    {
      AEQLog.d("AETemplateInfoFragment", "pag相关so未初始化成功");
      QQToast.a(getBaseActivity(), "pag相关so未初始化成功", 0).a();
      return;
    }
    initData();
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AETemplateInfoFragment
 * JD-Core Version:    0.7.0.1
 */