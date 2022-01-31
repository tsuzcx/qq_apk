import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class asmd
{
  static URLDrawable a;
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(120, 120, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, asmo paramasmo)
  {
    paramBaseActivity = (QQAppInterface)paramBaseActivity.getAppRuntime();
    if (!TextUtils.isEmpty(paramString5))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseAutoScaleParams = false;
      if (a != null) {
        a.cancelDownload();
      }
      a = URLDrawable.getDrawable(paramString5, localURLDrawableOptions);
      if (a.getStatus() == 1)
      {
        urk.c("ShortVideoShareUtil", "URLDrawable's status is SUCCESSED.");
        b(paramBaseActivity, paramString1, paramString2, paramString3, paramString4, a(a), paramasmo);
        return;
      }
      if (a.getStatus() == 2)
      {
        b(paramBaseActivity, paramString1, paramString2, paramString3, paramString4, null, paramasmo);
        a.downloadImediatly();
        return;
      }
      urk.c("ShortVideoShareUtil", "start load URLDrawable.");
      a.setURLDrawableListener(new asmh(paramBaseActivity, paramString1, paramString2, paramString3, paramString4, paramasmo));
      a.downloadImediatly();
      return;
    }
    b(paramBaseActivity, paramString1, paramString2, paramString3, paramString4, null, paramasmo);
  }
  
  static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    paramString1 = new awui(StructMsgForGeneralShare.class).c(131).a(paramString2).a("web", paramString4, null, null, null).a();
    paramString4 = awuv.a(2);
    paramString4.a(paramString5, paramString2, paramString3, 0);
    paramString1.addItem(paramString4);
    paramString2 = new Intent();
    paramString2.putExtra("forward_type", -3);
    paramString2.putExtra("stuctmsg_bytes", paramString1.getBytes());
    aphp.a(paramBaseActivity, paramString2, 123);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URLDrawable paramURLDrawable, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramString1 = new bahv(paramBaseActivity);
    paramString1.a(paramBaseActivity.getString(2131653614));
    paramString1.a(a(paramBaseActivity));
    paramString1.a(paramOnDismissListener);
    paramString1.a(new asme(paramString1, paramBaseActivity, paramString4, paramString2, paramString5, paramString3, paramString6, paramString7, paramQQAppInterface));
    try
    {
      paramString1.a();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + paramQQAppInterface);
    }
  }
  
  public static List<bahx>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    bahx localbahx = new bahx();
    localbahx.a = paramContext.getString(2131630983);
    localbahx.jdField_b_of_type_Int = 2130838732;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 2;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.a = paramContext.getString(2131630996);
    localbahx.jdField_b_of_type_Int = 2130838733;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 3;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.a = paramContext.getString(2131631003);
    localbahx.jdField_b_of_type_Int = 2130838736;
    localbahx.c = 9;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.a = paramContext.getString(2131630986);
    localbahx.jdField_b_of_type_Int = 2130838730;
    localbahx.c = 10;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private static void b(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = (QQAppInterface)paramBaseActivity.getAppRuntime();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString5);
    paramString5 = new Bundle();
    paramString5.putString("title", paramString2);
    paramString5.putString("desc", paramString3);
    paramString5.putString("summary", paramString3);
    paramString5.putString("detail_url", paramString4);
    paramString5.putString("url", paramString4);
    paramString5.putStringArrayList("image_url", localArrayList);
    paramString5.putString("targetUrl", paramString4);
    paramString5.putInt("cflag", 1);
    bfqn.a(paramString1, paramBaseActivity, paramString5, null, 124);
    new asmr().h("video").i("playpage_fw_suc").a().a(paramString1);
  }
  
  static void b(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, asmo paramasmo)
  {
    String str = String.valueOf(System.currentTimeMillis());
    if (!TextUtils.isEmpty(paramString5))
    {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString1.mUseAutoScaleParams = false;
      if (a != null) {
        a.cancelDownload();
      }
      a = URLDrawable.getDrawable(paramString5, paramString1);
      paramString5 = (QQAppInterface)paramBaseActivity.getAppRuntime();
      if (a.getStatus() == 1)
      {
        urk.c("ShortVideoShareUtil", "URLDrawable's status is SUCCESSED.");
        paramString1 = a(a);
        paramBaseActivity = paramString1;
        if (paramString1 == null) {
          paramBaseActivity = azvq.b(BaseApplicationImpl.getApplication().getResources(), 2130844397);
        }
        WXShareHelper.a().a(new asmj(str, paramasmo));
        WXShareHelper.a().a(str, paramString2, paramBaseActivity, paramString3, paramString4);
        new asmr().h("video").i("playpage_fw_suc").a().a(paramString5);
      }
    }
    else
    {
      return;
    }
    if (a.getStatus() == 2)
    {
      paramString1 = a(a);
      paramBaseActivity = paramString1;
      if (paramString1 == null) {
        paramBaseActivity = azvq.b(BaseApplicationImpl.getApplication().getResources(), 2130844397);
      }
      WXShareHelper.a().a(new asmk(str, paramasmo));
      WXShareHelper.a().a(str, paramString2, paramBaseActivity, paramString3, paramString4);
      a.downloadImediatly();
      new asmr().h("video").i("playpage_fw_suc").a().a(paramString5);
      return;
    }
    urk.c("ShortVideoShareUtil", "start load URLDrawable.");
    a.setURLDrawableListener(new asml(str, paramasmo, paramString2, paramString3, paramString4, paramString5));
    a.startDownload();
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap, asmo paramasmo)
  {
    String str = String.valueOf(System.currentTimeMillis());
    if (paramBitmap == null) {}
    for (paramString1 = azvq.b(BaseApplicationImpl.getApplication().getResources(), 2130844397);; paramString1 = paramBitmap)
    {
      WXShareHelper.a().a(new asmi(str, paramasmo));
      WXShareHelper.a().b(str, paramString2, paramString1, paramString3, paramString4);
      new asmr().h("video").i("playpage_fw_suc").a().a(paramQQAppInterface);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asmd
 * JD-Core Version:    0.7.0.1
 */