package com.tencent.aelight.camera.ae.play;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.edit.NodeText;
import java.io.File;
import org.light.device.LightDeviceUtils;

public class EditTextViewer
  extends ImageView
  implements View.OnClickListener
{
  private static final int DEFAUT_TEXT_MAX_COUNT = 10;
  private static final String TAG = "EditTextViewer";
  private EditTextViewer.OnDownloadDialogListener downloadDialogLister;
  private boolean inited = false;
  private boolean isAnimationPlaying = false;
  private boolean isFirstRender = true;
  private EditTextViewer.OnSaveTextInfoListener listener;
  private int mActionBarHeight = 0;
  private Activity mActivity;
  private LayerDrawable mAnimationDrawable;
  private Drawable mAnimationSolidDrawable;
  private Bitmap mBlankBitmap;
  private EditTextDialog mEditTextDialog;
  private boolean mIsTextSelected = false;
  private String mLastUseText;
  private Matrix mMatrix = new Matrix();
  private NodeItem mNodeItem = new NodeItem();
  private String mTemplateID;
  private ValueAnimator mValueAnimator;
  private String materialId;
  
  public EditTextViewer(Context paramContext)
  {
    super(paramContext);
    this.mActivity = ((Activity)paramContext);
    setOnClickListener(this);
    this.isFirstRender = true;
    setBackgroundDrawable(getResources().getDrawable(2064056408));
    this.mAnimationDrawable = ((LayerDrawable)getResources().getDrawable(2064056407));
    this.mAnimationSolidDrawable = this.mAnimationDrawable.findDrawableByLayerId(2064122261);
  }
  
  private boolean deleteSingleFile(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.isFile()) && (paramString.delete());
  }
  
  private void drawAnimationIfNeed(Canvas paramCanvas)
  {
    if (!this.isAnimationPlaying) {
      return;
    }
    this.mAnimationDrawable.setBounds(0, 0, getWidth(), getHeight());
    this.mAnimationDrawable.draw(paramCanvas);
  }
  
  private void drawBlankText()
  {
    this.mNodeItem.bitmap = this.mBlankBitmap;
  }
  
  private void drawText() {}
  
  private String getValue()
  {
    return "";
  }
  
  private void hideDownloadDialog()
  {
    EditTextViewer.OnDownloadDialogListener localOnDownloadDialogListener = this.downloadDialogLister;
    if (localOnDownloadDialogListener != null) {
      localOnDownloadDialogListener.hideDownloadDialog();
    }
  }
  
  private void onGetFontDataSuccess(GetFontDataRsp paramGetFontDataRsp)
  {
    saveFontFile(getContext(), paramGetFontDataRsp.FontData);
  }
  
  private String saveFontFile(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("temp.ttf");
      paramContext = localStringBuilder.toString();
      FileUtils.writeFile(paramArrayOfByte, paramContext);
      return paramContext;
    }
    return "";
  }
  
  private void showDownloadDialog()
  {
    EditTextViewer.OnDownloadDialogListener localOnDownloadDialogListener = this.downloadDialogLister;
    if (localOnDownloadDialogListener != null) {
      localOnDownloadDialogListener.showDownloadDialog();
    }
  }
  
  private void showTextEditDlg() {}
  
  private void toastInUIThread(int paramInt)
  {
    this.mActivity.runOnUiThread(new EditTextViewer.1(this, paramInt));
  }
  
  private void updateParams()
  {
    Object localObject = this.mNodeItem;
    ((NodeItem)localObject).cropBitmap = null;
    if (((NodeItem)localObject).bitmap != null) {
      setImageBitmap(this.mNodeItem.bitmap);
    }
    localObject = this.listener;
    if (localObject != null) {
      ((EditTextViewer.OnSaveTextInfoListener)localObject).onSaveTextInfo(this.mNodeItem);
    }
    setTextSelected(true);
    this.isFirstRender = false;
  }
  
  public void clearBitmaps()
  {
    if ((this.mNodeItem.bitmap != null) && (!this.mNodeItem.bitmap.isRecycled())) {
      this.mNodeItem.bitmap.recycle();
    }
    if ((this.mNodeItem.cropBitmap != null) && (!this.mNodeItem.cropBitmap.isRecycled())) {
      this.mNodeItem.cropBitmap.recycle();
    }
    setImageBitmap(null);
    clearTextWMElement();
    this.inited = false;
  }
  
  public void clearTextWMElement() {}
  
  public NodeItem getNode()
  {
    return this.mNodeItem;
  }
  
  public int getNodeGroupID()
  {
    return this.mNodeItem.nodeGroupID;
  }
  
  public void initTextWMElement()
  {
    this.inited = true;
    if (this.mNodeItem.nodeTextMaxCount <= 0) {
      this.mNodeItem.nodeTextMaxCount = 10;
    }
  }
  
  public void onClick(View paramView)
  {
    if (!this.inited) {
      initTextWMElement();
    }
    showTextEditDlg();
    setTextSelected(false);
    AEBaseDataReporter.a().m();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      int k;
      try
      {
        if ((this.mNodeItem.bitmap != null) && (getWidth() != 0) && (getHeight() != 0))
        {
          int n = this.mNodeItem.bitmap.getWidth();
          j = this.mNodeItem.bitmap.getHeight();
          int i1 = getWidth();
          int m = getHeight();
          NodeText localNodeText = this.mNodeItem.nodeTextGroup;
          i = 0;
          k = 0;
          if (localNodeText == null) {
            break label212;
          }
          if ("left".equals(this.mNodeItem.nodeTextGroup.alignment))
          {
            k = m / 2;
            j /= 2;
          }
          else if ("right".equals(this.mNodeItem.nodeTextGroup.alignment))
          {
            i = i1 - n;
            k = m / 2;
            j /= 2;
          }
          else
          {
            i = i1 / 2 - n / 2;
            k = m / 2;
            j /= 2;
            break label204;
            this.mMatrix.postTranslate(i, j);
            setImageMatrix(this.mMatrix);
          }
        }
        else
        {
          super.onDraw(paramCanvas);
          drawAnimationIfNeed(paramCanvas);
          return;
        }
      }
      catch (Throwable paramCanvas)
      {
        return;
      }
      label204:
      int j = k - j;
      continue;
      label212:
      j = 0;
      int i = k;
    }
  }
  
  public void renderAndSaveTexture(String paramString)
  {
    if (!LightDeviceUtils.isNetworkAvailable(AEModule.getContext()))
    {
      QQToast.a(getContext(), 2064515249, 1).a();
      return;
    }
    if (!this.inited) {
      initTextWMElement();
    }
  }
  
  public Bitmap renderBitmap()
  {
    if (!this.inited) {
      initTextWMElement();
    }
    return null;
  }
  
  public void setActionBarHeight(int paramInt)
  {
    this.mActionBarHeight = paramInt;
  }
  
  public void setMaterialId(String paramString)
  {
    this.materialId = paramString;
  }
  
  public void setNodeBitmap(Bitmap paramBitmap)
  {
    this.mNodeItem.bitmap = paramBitmap;
  }
  
  public void setNodeInfo(NodeItem paramNodeItem)
  {
    this.mNodeItem.nodeID = paramNodeItem.nodeID;
    this.mNodeItem.nodeGroupID = paramNodeItem.nodeGroupID;
    this.mNodeItem.once = paramNodeItem.once;
    this.mNodeItem.maskRect = paramNodeItem.maskRect;
    this.mNodeItem.nodeTextMaxCount = paramNodeItem.nodeTextMaxCount;
    this.mNodeItem.zIndex = paramNodeItem.zIndex;
    this.mNodeItem.nodeTextGroup.copyFrom(paramNodeItem.nodeTextGroup);
  }
  
  public void setOnDownloadDialogListener(EditTextViewer.OnDownloadDialogListener paramOnDownloadDialogListener)
  {
    this.downloadDialogLister = paramOnDownloadDialogListener;
  }
  
  public void setOnSaveTextInfoListener(EditTextViewer.OnSaveTextInfoListener paramOnSaveTextInfoListener)
  {
    this.listener = paramOnSaveTextInfoListener;
  }
  
  public void setTemplateID(String paramString)
  {
    this.mTemplateID = paramString;
  }
  
  public void setTextSelected(boolean paramBoolean)
  {
    this.mIsTextSelected = paramBoolean;
  }
  
  public void startAnimaterIfNeed()
  {
    if (this.mValueAnimator == null)
    {
      this.mValueAnimator = ValueAnimator.ofInt(new int[] { 150, 0 });
      this.mValueAnimator.setDuration(700L);
      this.mValueAnimator.setRepeatCount(4);
      this.mValueAnimator.setInterpolator(new DecelerateInterpolator());
      this.mValueAnimator.setRepeatMode(2);
      this.mValueAnimator.addUpdateListener(new EditTextViewer.2(this));
      this.mValueAnimator.addListener(new EditTextViewer.3(this));
    }
    if (this.mValueAnimator.isRunning()) {
      this.mValueAnimator.cancel();
    }
    this.mValueAnimator.start();
  }
  
  public void updateMatrix(int paramInt1, int paramInt2)
  {
    int m = this.mNodeItem.bitmap.getWidth();
    int k = this.mNodeItem.bitmap.getHeight();
    NodeText localNodeText = this.mNodeItem.nodeTextGroup;
    int i = 0;
    int j = 0;
    if (localNodeText != null)
    {
      if ("left".equals(this.mNodeItem.nodeTextGroup.alignment))
      {
        i = paramInt2 / 2;
        paramInt2 = k / 2;
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 = i - paramInt2;
        break;
        if ("right".equals(this.mNodeItem.nodeTextGroup.alignment))
        {
          paramInt1 -= m;
          i = paramInt2 / 2;
          paramInt2 = k / 2;
        }
        else
        {
          paramInt1 = paramInt1 / 2 - m / 2;
          i = paramInt2 / 2;
          paramInt2 = k / 2;
        }
      }
    }
    paramInt2 = 0;
    paramInt1 = i;
    this.mMatrix.postTranslate(paramInt1, paramInt2);
    setImageMatrix(this.mMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.EditTextViewer
 * JD-Core Version:    0.7.0.1
 */