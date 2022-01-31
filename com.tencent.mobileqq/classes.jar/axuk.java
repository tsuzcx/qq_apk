import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.BaseView;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class axuk
  extends axug
{
  public axvm a;
  public MqqHandler a;
  
  public axuk()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new axul(this);
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Axvm != null) && (this.jdField_a_of_type_Axvm.a != null)) {
      return this.jdField_a_of_type_Axvm.a.a();
    }
    return 0L;
  }
  
  public Intent a(AIOFileVideoData paramAIOFileVideoData, Activity paramActivity)
  {
    boolean bool = true;
    if ((paramAIOFileVideoData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      Intent localIntent = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int, 0);
      if (localIntent != null)
      {
        if (paramAIOFileVideoData.b == 1) {}
        for (;;)
        {
          axux.a(paramActivity, localIntent, bool);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
          return localIntent;
          bool = false;
        }
      }
    }
    return null;
  }
  
  public AIOFileVideoData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
      return (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).l = false;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong1);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      localAIOFileVideoData.progress = ((int)(paramInt3 / 10000.0F * (float)localAIOFileVideoData.jdField_c_of_type_Long));
      localRichMediaBrowserInfo.baseData = localAIOFileVideoData;
      updateItem(localRichMediaBrowserInfo);
    }
    localRichMediaBrowserInfo = getSelectedItem();
    if ((paramInt2 == 103) && (localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOFileVideoData)) && (((AIOFileVideoData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long == paramLong1)) {
      this.jdField_a_of_type_Axvm.updateUI();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    AIOFileVideoData localAIOFileVideoData;
    if ((paramInt2 == 269484034) && (localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      if (paramInt3 == 1)
      {
        localAIOFileVideoData.jdField_c_of_type_JavaLangString = paramString;
        localAIOFileVideoData.f = true;
        localAIOFileVideoData.h = true;
        localAIOFileVideoData.l = false;
        localAIOFileVideoData.status = 0;
        localAIOFileVideoData.progress = 0;
        localAIOFileVideoData.e = null;
        localAIOFileVideoData.d = null;
        paramBoolean = localAIOFileVideoData.n;
        localRichMediaBrowserInfo.baseData = localAIOFileVideoData;
        updateItem(localRichMediaBrowserInfo);
      }
    }
    for (;;)
    {
      if (paramInt2 == 269484034)
      {
        paramString = getSelectedItem();
        if ((paramString != null) && ((paramString.baseData instanceof AIOBrowserBaseData)) && (((AIOBrowserBaseData)paramString.baseData).jdField_a_of_type_Long == paramLong)) {
          if (paramBoolean)
          {
            if (paramInt3 != 1) {
              break label232;
            }
            QQToast.a(this.jdField_a_of_type_Axvm.mContext, 2, this.jdField_a_of_type_Axvm.mContext.getString(2131719309), 0).a();
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Axvm.updateUI();
        return;
        if (paramInt3 != 2) {
          break;
        }
        localAIOFileVideoData.f = false;
        break;
        label232:
        if (paramInt3 == 2) {
          QQToast.a(this.jdField_a_of_type_Axvm.mContext, 1, this.jdField_a_of_type_Axvm.mContext.getString(2131719324), 0).a();
        }
      }
      paramBoolean = false;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Axvm.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public boolean a(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
      return ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).l;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Axuh != null) && (this.jdField_a_of_type_Axuh.a != null) && (this.jdField_a_of_type_Axuh.a() != null))
    {
      boolean bool = false;
      AIOFileVideoData localAIOFileVideoData = a();
      if (localAIOFileVideoData != null) {
        bool = bdcs.b(localAIOFileVideoData.jdField_c_of_type_JavaLangString);
      }
      if (bool)
      {
        if (!bngs.b()) {
          break label117;
        }
        this.jdField_a_of_type_Axuh.a().a((int)aekt.a(bngs.jdField_a_of_type_Int, this.jdField_a_of_type_Axvm.mContext.getResources()) + 46);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Axuh.a().c();
      this.jdField_a_of_type_Axuh.a().e();
      this.jdField_a_of_type_Axuh.a.a();
      return;
      label117:
      this.jdField_a_of_type_Axuh.a().a(46);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.mActiveDrawable.remove(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public void b(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).m = false;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isVideoEnable() = " + aocg.f());
    }
    return aocg.f();
  }
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    super.setGalleryModel(paramBrowserBaseModel);
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    super.setGalleryView(paramBaseView);
    if ((paramBaseView instanceof axvm)) {
      this.jdField_a_of_type_Axvm = ((axvm)paramBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axuk
 * JD-Core Version:    0.7.0.1
 */