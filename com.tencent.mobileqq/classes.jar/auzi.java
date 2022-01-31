import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.ArrayList;
import java.util.List;

public class auzi
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
  
  static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, auzu paramauzu)
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
        wsv.c("ShortVideoShareUtil", "URLDrawable's status is SUCCESSED.");
        b(paramBaseActivity, paramString1, paramString2, paramString3, paramString4, a(a), paramauzu);
        return;
      }
      if (a.getStatus() == 2)
      {
        b(paramBaseActivity, paramString1, paramString2, paramString3, paramString4, null, paramauzu);
        a.downloadImediatly();
        return;
      }
      wsv.c("ShortVideoShareUtil", "start load URLDrawable.");
      a.setURLDrawableListener(new auzn(paramBaseActivity, paramString1, paramString2, paramString3, paramString4, paramauzu));
      a.downloadImediatly();
      return;
    }
    b(paramBaseActivity, paramString1, paramString2, paramString3, paramString4, null, paramauzu);
  }
  
  static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    paramString1 = new azqg(StructMsgForGeneralShare.class).c(131).a(paramString2).a("web", paramString4, null, null, null).a();
    paramString4 = azqt.a(2);
    paramString4.a(paramString5, paramString2, paramString3, 0);
    paramString1.addItem(paramString4);
    paramString2 = new Intent();
    paramString2.putExtra("forward_type", -3);
    paramString2.putExtra("stuctmsg_bytes", paramString1.getBytes());
    arum.a(paramBaseActivity, paramString2, 123);
  }
  
  static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, int paramInt, String paramString6)
  {
    paramString1 = new Intent();
    paramString4 = new azqg(StructMsgForGeneralShare.class).c(131).a(paramString2).a("web", paramString4, null, null, null).a();
    azqk localazqk = azqt.a(2);
    localazqk.a(paramString5, paramString2, paramString3, 0);
    paramString4.addItem(localazqk);
    paramString1.putExtra("forward_type", -3);
    paramString1.putExtra("stuctmsg_bytes", paramString4.getBytes());
    paramString1.putExtra("key_req", ForwardRecentActivity.f);
    paramString1.putExtra("key_direct_show_uin_type", paramInt);
    paramString1.putExtra("key_direct_show_uin", paramString6);
    arum.a(paramBaseActivity, paramString1, ForwardRecentTranslucentActivity.class, 123, 100500, "biz_src_hdsp_nearby");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URLDrawable paramURLDrawable, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramBaseActivity.getIntent().putExtra("big_brother_source_key", "biz_src_hdsp_nearby");
    paramString1 = new ArrayList();
    paramURLDrawable = new ArrayList();
    paramString1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    paramString1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    paramString1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    paramString1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).canceledOnTouchOutside = true;
    ((ShareActionSheetV2.Param)localObject).context = paramBaseActivity;
    ((ShareActionSheetV2.Param)localObject).fullScreen = true;
    ((ShareActionSheetV2.Param)localObject).lp = new ViewGroup.LayoutParams(-1, -2);
    localObject = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 27);
    ((ShareActionSheet)localObject).setIntentForStartForwardRecentActivity(localIntent);
    ((ShareActionSheet)localObject).setRowVisibility(0, 0, 0);
    ((ShareActionSheet)localObject).setActionSheetItems(paramString1, paramURLDrawable);
    ((ShareActionSheet)localObject).setItemClickListenerV2(new auzj(paramBaseActivity, paramString2, paramString4, paramString5, paramString3, paramString6, paramString7, paramQQAppInterface));
    ((ShareActionSheet)localObject).setCancelListener(new auzm(paramOnDismissListener));
    ((ShareActionSheet)localObject).show();
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
    bjao.a(paramString1, paramBaseActivity, paramString5, null, 124);
    new auzx().h("video").i("playpage_fw_suc").a().a(paramString1);
  }
  
  static void b(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, auzu paramauzu)
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
        wsv.c("ShortVideoShareUtil", "URLDrawable's status is SUCCESSED.");
        paramString1 = a(a);
        paramBaseActivity = paramString1;
        if (paramString1 == null) {
          paramBaseActivity = bcwc.b(BaseApplicationImpl.getApplication().getResources(), 2130844842);
        }
        WXShareHelper.a().a(new auzp(str, paramauzu));
        WXShareHelper.a().a(str, paramString2, paramBaseActivity, paramString3, paramString4);
        new auzx().h("video").i("playpage_fw_suc").a().a(paramString5);
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
        paramBaseActivity = bcwc.b(BaseApplicationImpl.getApplication().getResources(), 2130844842);
      }
      WXShareHelper.a().a(new auzq(str, paramauzu));
      WXShareHelper.a().a(str, paramString2, paramBaseActivity, paramString3, paramString4);
      a.downloadImediatly();
      new auzx().h("video").i("playpage_fw_suc").a().a(paramString5);
      return;
    }
    wsv.c("ShortVideoShareUtil", "start load URLDrawable.");
    a.setURLDrawableListener(new auzr(str, paramauzu, paramString2, paramString3, paramString4, paramString5));
    a.startDownload();
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap, auzu paramauzu)
  {
    String str = String.valueOf(System.currentTimeMillis());
    if (paramBitmap == null) {}
    for (paramString1 = bcwc.b(BaseApplicationImpl.getApplication().getResources(), 2130844842);; paramString1 = paramBitmap)
    {
      WXShareHelper.a().a(new auzo(str, paramauzu));
      WXShareHelper.a().b(str, paramString2, paramString1, paramString3, paramString4);
      new auzx().h("video").i("playpage_fw_suc").a().a(paramQQAppInterface);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auzi
 * JD-Core Version:    0.7.0.1
 */