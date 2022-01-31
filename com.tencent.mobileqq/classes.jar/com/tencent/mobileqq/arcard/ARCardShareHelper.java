package com.tencent.mobileqq.arcard;

import aamf;
import aamm;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.arcard.ARWordingBless.RubberStamp;
import com.tencent.mobileqq.arcard.ARWordingBless.RubberStampConfig;
import com.tencent.mobileqq.arcard.ARWordingBless.RubberStampConfig.RubberStampConfigBuilder;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;

public class ARCardShareHelper
{
  int jdField_a_of_type_Int;
  public Activity a;
  public Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public AppInterface a;
  public ARCommonConfigInfo a;
  public ArCloudConfigInfo a;
  private RubberStamp jdField_a_of_type_ComTencentMobileqqArcardARWordingBlessRubberStamp;
  public ShareActionSheetBuilder a;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public ARCardShareHelper(Context paramContext, AppInterface paramAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqArcardARWordingBlessRubberStamp = new RubberStamp(paramActivity);
  }
  
  private Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    try
    {
      localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), 2130842220, (BitmapFactory.Options)localObject1);
      if (localObject1 == null) {
        return paramBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject2;
      for (;;)
      {
        localObject2 = null;
      }
      Object localObject4 = localObject2.copy(localObject2.getConfig(), true);
      int i = ((Bitmap)localObject4).getHeight();
      Object localObject3 = localObject4;
      if (i != 116)
      {
        int j = ((Bitmap)localObject4).getWidth();
        float f = 116.0F / i;
        localObject3 = new Matrix();
        ((Matrix)localObject3).postScale(f, f);
        localObject3 = Bitmap.createBitmap((Bitmap)localObject4, 0, 0, j, i, (Matrix)localObject3, true);
      }
      localObject4 = new RubberStampConfig.RubberStampConfigBuilder().a(paramBitmap).a(8, 0).c(4).a();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqArcardARWordingBlessRubberStamp.a((Bitmap)localObject3, new RubberStampConfig[] { localObject4 });
      localObject2.recycle();
      paramBitmap.recycle();
      return localObject3;
    }
  }
  
  private Bitmap a(String paramString)
  {
    Object localObject4 = "长按识别二维码，看看你收到几张AR贺卡。";
    Object localObject2 = "张好友送的AR贺卡，看看你的？";
    Object localObject1;
    Object localObject5;
    Object localObject3;
    Paint localPaint;
    if (this.jdField_a_of_type_Int <= 5)
    {
      localObject1 = "优雅地比了个心，从指间";
      localObject4 = "长按识别二维码，召唤你的AR贺卡。";
      localObject2 = "召唤出神奇AR贺卡，你也来试试？";
      localObject5 = "" + this.jdField_a_of_type_Int;
      localObject3 = paramString + (String)localObject1;
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setUnderlineText(false);
      localPaint.setTypeface(Typeface.DEFAULT_BOLD);
      localPaint.setTextSize(42.0F);
      if (this.jdField_a_of_type_Int <= 5) {
        break label761;
      }
      if (localPaint.measureText((String)localObject3) >= 654.0F) {
        break label588;
      }
      localObject5 = (String)localObject1 + (String)localObject5;
      localObject3 = paramString + (String)localObject5;
      localObject1 = localObject2;
      localObject2 = localObject5;
    }
    for (;;)
    {
      if (localPaint.measureText((String)localObject3) >= 654.0F)
      {
        do
        {
          localObject5 = paramString.substring(0, paramString.length() - 2);
          localObject3 = (String)localObject5 + "..." + (String)localObject2;
          paramString = (String)localObject5;
        } while (localPaint.measureText((String)localObject3) >= 654.0F);
        paramString = (String)localObject5 + "...";
        if (QLog.isColorLevel()) {
          QLog.d("ARCardShareHelper", 2, "getTextInfoBitmap, strLine1 = " + (String)localObject3 + "    strLine2 = " + (String)localObject1);
        }
        paramString = new RubberStampConfig.RubberStampConfigBuilder().b(Color.parseColor("#FFE632")).a(42).a(Typeface.DEFAULT_BOLD).a(paramString).a(0, 0, 42).a();
        localObject2 = new RubberStampConfig.RubberStampConfigBuilder().b(Color.parseColor("#FFFFFF")).a(42).a(Typeface.DEFAULT_BOLD).a((String)localObject2).a(0, paramString.k() + 5, 42).a();
        i = paramString.l() + 42 + 15;
        localObject1 = new RubberStampConfig.RubberStampConfigBuilder().b(Color.parseColor("#FFFFFF")).a(42).a(Typeface.DEFAULT_BOLD).a((String)localObject1).a(0, 0, i).a();
        i = i + ((RubberStampConfig)localObject1).l() + 12;
        localObject3 = new RubberStampConfig.RubberStampConfigBuilder().b(Color.parseColor("#FFFFFF")).a(28).a((String)localObject4).a(0, 0, i).a();
        localObject4 = Bitmap.createBitmap(664, i + ((RubberStampConfig)localObject3).l() + 8, Bitmap.Config.ARGB_8888);
        return this.jdField_a_of_type_ComTencentMobileqqArcardARWordingBlessRubberStamp.a((Bitmap)localObject4, new RubberStampConfig[] { paramString, localObject2, localObject1, localObject3 });
        if ((this.jdField_a_of_type_Int > 5) && (this.jdField_a_of_type_Int <= 10))
        {
          localObject1 = "2018众星捧月，收到";
          break;
        }
        localObject1 = "2018人气旺翻天，收到";
        break;
        label588:
        localObject5 = (String)localObject5 + (String)localObject2;
        localObject2 = localObject1;
        localObject1 = localObject5;
        continue;
      }
      int i = 0;
      label623:
      int j = i + 1;
      if (j == ((String)localObject1).length()) {}
      for (;;)
      {
        i = j - 1;
        localObject2 = (String)localObject2 + ((String)localObject1).substring(0, i);
        localObject3 = paramString + (String)localObject2;
        localObject1 = ((String)localObject1).substring(i);
        break;
        localObject3 = (String)localObject2 + ((String)localObject1).substring(0, j);
        i = j;
        if (localPaint.measureText(paramString + (String)localObject3) <= 654.0F) {
          break label623;
        }
      }
      label761:
      localObject5 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject5;
    }
  }
  
  private String a()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.h;
    int i = str1.indexOf("|");
    if (i > 0) {
      str1 = str1.substring(i + 1);
    }
    for (;;)
    {
      String str3 = ((ScanTorchActivity)this.jdField_a_of_type_AndroidAppActivity).e();
      String str2 = str3;
      if (str3.length() > 6) {
        str2 = str3.substring(0, 5) + "...";
      }
      str3 = str1;
      if (!str2.isEmpty()) {
        str3 = str1.replace("%s", str2);
      }
      return str3.replace("%d", "" + this.jdField_a_of_type_Int);
    }
  }
  
  private String a(int paramInt)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.e;
    String str3 = ((ScanTorchActivity)this.jdField_a_of_type_AndroidAppActivity).getCurrentAccountUin();
    String str2 = str1;
    if (!str3.isEmpty())
    {
      str2 = NearbyURLSafeUtil.a(str3);
      if (str1.endsWith("&")) {
        break label97;
      }
      str1 = str1 + "&";
    }
    label97:
    for (;;)
    {
      str2 = str1 + "fromuser=" + str2;
      return str2;
    }
  }
  
  private List[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430108);
    localActionSheetItem.jdField_b_of_type_Int = 2130838336;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 2;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430114);
    localActionSheetItem.jdField_b_of_type_Int = 2130838337;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 3;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430126);
    localActionSheetItem.jdField_b_of_type_Int = 2130838340;
    localActionSheetItem.c = 9;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430127);
    localActionSheetItem.jdField_b_of_type_Int = 2130838334;
    localActionSheetItem.c = 10;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  private boolean b()
  {
    long l = System.currentTimeMillis();
    String str = ARResouceDir.c() + "arcard_share_bigbg.png";
    Object localObject1;
    int i;
    try
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject1);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap.copy(this.jdField_a_of_type_AndroidGraphicsBitmap.getConfig(), true);
      localBitmap = ARCardUtils.a(((ScanTorchActivity)this.jdField_a_of_type_AndroidAppActivity).g());
      i = localBitmap.getHeight();
      if (i == 100) {
        break label344;
      }
    }
    int j = localBitmap.getWidth();
    float f = 100.0F / i;
    Object localObject2 = new Matrix();
    ((Matrix)localObject2).postScale(f, f);
    Bitmap localBitmap = Bitmap.createBitmap(localBitmap, 0, 0, j, i, (Matrix)localObject2, true);
    label344:
    for (;;)
    {
      localObject2 = ((ScanTorchActivity)this.jdField_a_of_type_AndroidAppActivity).e();
      localBitmap = a(localBitmap);
      localObject2 = a((String)localObject2);
      RubberStampConfig localRubberStampConfig1 = new RubberStampConfig.RubberStampConfigBuilder().a(localBitmap).a(0, 40, 828).a();
      RubberStampConfig localRubberStampConfig2 = new RubberStampConfig.RubberStampConfigBuilder().a((Bitmap)localObject2).a(0, 40, localRubberStampConfig1.g() + localRubberStampConfig1.l() + 18).a();
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqArcardARWordingBlessRubberStamp.a((Bitmap)localObject1, new RubberStampConfig[] { localRubberStampConfig1, localRubberStampConfig2 });
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_JavaLangString = c();
      }
      localBitmap.recycle();
      ((Bitmap)localObject2).recycle();
      if (QLog.isColorLevel()) {
        QLog.i("ARCardShareHelper", 2, "prepareImage finish cost " + (System.currentTimeMillis() - l));
      }
      return true;
    }
  }
  
  @Nullable
  private String c()
  {
    do
    {
      try
      {
        str1 = "temp_arcard_share_" + System.currentTimeMillis() + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + ".png";
        str1 = QRUtils.a(this.jdField_a_of_type_AndroidAppActivity, str1, this.jdField_a_of_type_AndroidGraphicsBitmap);
        String str2 = str1;
        str2 = str1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ARCardShareHelper", 2, "saveBitmapFile, path = " + str1);
            str2 = str1;
          }
          return str2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          String str1;
          continue;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        str1 = null;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ARCardShareHelper", 2, localOutOfMemoryError1.getMessage());
    return str1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) {}
    while (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a().isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a().dismiss();
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      aamf localaamf = new aamf(this);
      paramOnDismissListener = new aamm(this, paramOnDismissListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder((Activity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131433100));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(localaamf);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(paramOnDismissListener);
    }
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a().isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
      }
      return;
    }
    catch (Exception paramOnDismissListener)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + paramOnDismissListener);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool1;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARRelationShipAIOMsg != null))
    {
      bool1 = true;
      if (!bool1)
      {
        localObject = new StringBuilder().append("checkShareData is false mArCloudConfigInfo != null = ");
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null) {
          break label227;
        }
        bool2 = true;
        label53:
        localObject = ((StringBuilder)localObject).append(bool2).append(" mARCommonConfigInfo != null = ");
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo == null) {
          break label232;
        }
      }
    }
    label227:
    label232:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("ARCardShareHelper", 2, bool2);
      if ((!bool1) || (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return bool1;
      }
      localObject = ARResouceDir.c() + "arcard_share_bigbg.png";
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)localObject, localOptions);
      if ((localOptions.outHeight > 0) && (localOptions.outWidth > 0)) {
        return bool1;
      }
      QLog.d("ARCardShareHelper", 2, "mShareBitmap check is false options.outHeight = " + localOptions.outHeight);
      QLog.d("ARCardShareHelper", 2, "mShareBitmap check is false options.outWidth = " + localOptions.outWidth);
      return false;
      bool1 = false;
      break;
      bool2 = false;
      break label53;
    }
    return bool1;
  }
  
  public boolean a(ArCloudConfigInfo paramArCloudConfigInfo, ARCommonConfigInfo paramARCommonConfigInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
    this.jdField_a_of_type_Int = paramInt;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardShareHelper
 * JD-Core Version:    0.7.0.1
 */