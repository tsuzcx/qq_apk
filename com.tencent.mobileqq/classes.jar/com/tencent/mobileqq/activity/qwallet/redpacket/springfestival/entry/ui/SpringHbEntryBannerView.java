package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import agpg;
import agtw;
import agun;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import baip;
import bajq;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;

public class SpringHbEntryBannerView
  extends RelativeLayout
{
  private volatile long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private String jdField_a_of_type_JavaLangString = "entry_coming.png";
  private volatile boolean jdField_a_of_type_Boolean;
  private String b = "entry_on.png";
  
  public SpringHbEntryBannerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SpringHbEntryBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SpringHbEntryBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private Drawable a(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("spring_hb").append(File.separator).append("qvip_pay_");
      if (paramInt == 1) {}
      for (Object localObject = this.b;; localObject = this.jdField_a_of_type_JavaLangString)
      {
        localObject = agtw.a((String)localObject, true);
        if (QLog.isColorLevel()) {
          QLog.d("springHb_SpringHbEntryView", 2, "getDefaultDrawable -- >,bitmap:" + localObject + ",status:" + paramInt);
        }
        return new BitmapDrawable((Bitmap)localObject);
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntryView", 1, localThrowable, new Object[0]);
    }
  }
  
  private void a()
  {
    View.inflate(getContext(), 2131496067, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303060));
  }
  
  private void a(int paramInt1, PreloadManager.PathResult paramPathResult, int paramInt2, SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo)
  {
    int i;
    int j;
    label14:
    String str;
    label68:
    boolean bool;
    if (paramInt1 == 0)
    {
      i = 1;
      if (paramPathResult == null) {
        break label170;
      }
      j = 1;
      if (((j & i) == 0) || (baip.a(paramPathResult.folderPath))) {
        break label257;
      }
      if (paramInt2 != 1) {
        break label176;
      }
      str = paramPathResult.folderPath + "/banner_entry/" + this.b;
      bool = new File(str).exists();
      if (bool) {
        break label210;
      }
      a(paramInt2, paramBannerInfo);
      paramBannerInfo = str;
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("springHb_SpringHbEntryView", 2, "setBannerBg >>> getResPath resCode:" + paramInt1 + ",pathRes:" + paramPathResult + ",filePath:" + paramBannerInfo + ",exists:" + bool);
      }
      return;
      i = 0;
      break;
      label170:
      j = 0;
      break label14;
      label176:
      str = paramPathResult.folderPath + "/banner_entry/" + this.jdField_a_of_type_JavaLangString;
      break label68;
      label210:
      Drawable localDrawable1 = a(paramInt2);
      Drawable localDrawable2 = QWalletPicHelper.getDrawableForWallet(str, localDrawable1, localDrawable1, null);
      ThreadManagerV2.getUIHandlerV2().post(new SpringHbEntryBannerView.2(this, paramBannerInfo, localDrawable2, localDrawable1));
      paramBannerInfo = str;
      continue;
      label257:
      a(paramInt2, paramBannerInfo);
      bool = false;
      paramBannerInfo = null;
    }
  }
  
  private void a(int paramInt, SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("spring_hb").append(File.separator).append("qvip_pay_");
    if (paramInt == 1) {}
    for (String str = this.b;; str = this.jdField_a_of_type_JavaLangString)
    {
      ThreadManagerV2.executeOnFileThread(new SpringHbEntryBannerView.4(this, str, paramInt, paramBannerInfo));
      return;
    }
  }
  
  private void a(ViewGroup.LayoutParams paramLayoutParams, SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo)
  {
    try
    {
      int i = bajq.b(5.0F);
      if ((this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).topMargin = i;
      }
      i = paramBannerInfo.bannerHeight + i;
      if ((paramLayoutParams != null) && (paramLayoutParams.height != i))
      {
        paramLayoutParams.height = i;
        this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
      }
      if (QLog.isColorLevel()) {
        QLog.d("springHb_SpringHbEntryView", 2, "resetHeight >>> viewHeight:" + i);
      }
      return;
    }
    catch (Throwable paramLayoutParams)
    {
      QLog.e("springHb_SpringHbEntryView", 1, paramLayoutParams, new Object[0]);
    }
  }
  
  private void a(SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo)
  {
    if (getLayoutParams() == null)
    {
      ThreadManagerV2.getUIHandlerV2().post(new SpringHbEntryBannerView.3(this, paramBannerInfo));
      return;
    }
    a(getLayoutParams(), paramBannerInfo);
  }
  
  public void setBannerBg(SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        if ((!paramBoolean) && (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 2000L)) {
          return;
        }
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        localObject = paramBannerInfo.bannerUrl;
        i = paramBannerInfo.status;
        if (baip.a((String)localObject)) {
          continue;
        }
        if (!paramBoolean) {
          continue;
        }
        DownloadParam localDownloadParam = new DownloadParam();
        localDownloadParam.filePos = 0;
        localDownloadParam.url = ((String)localObject);
        this.jdField_a_of_type_Boolean = true;
        PreloadManager.a().a(localDownloadParam, new agun(this, i, paramBannerInfo));
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int i;
        QLog.d("springHb_SpringHbEntryView", 1, localThrowable, new Object[0]);
        continue;
        a(i, paramBannerInfo);
        continue;
        a(i, paramBannerInfo);
        continue;
      }
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("springHb_SpringHbEntryView", 2, "setBannerBg-->info:" + paramBannerInfo + ",hasOpenDesktop:" + paramBoolean);
      return;
      localObject = PreloadManager.a((String)localObject);
      if ((localObject == null) || (baip.a(((PreloadManager.PathResult)localObject).folderPath)) || (!new File(((PreloadManager.PathResult)localObject).folderPath).exists())) {
        continue;
      }
      a(0, (PreloadManager.PathResult)localObject, i, paramBannerInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntryBannerView
 * JD-Core Version:    0.7.0.1
 */