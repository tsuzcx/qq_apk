import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import java.util.ArrayList;
import java.util.List;

public class asyl
  implements AdapterView.OnItemClickListener
{
  private static URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private Context jdField_a_of_type_AndroidContentContext;
  protected ShareActionSheetBuilder a;
  private nlo jdField_a_of_type_Nlo;
  
  public asyl(Context paramContext, nlo paramnlo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Nlo = paramnlo;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.b = paramString1;
    localQZoneShareData.c = paramString2;
    localQZoneShareData.a = new ArrayList();
    localQZoneShareData.a.add(paramString4);
    localQZoneShareData.d = paramString3;
    bjev.a(paramContext, String.valueOf(bfbm.a().a()), localQZoneShareData, null, 1003);
    azqs.b(null, "dc00898", "", this.jdField_a_of_type_Nlo.a.a, "0X80092A4", "0X80092A4", 0, 0, this.jdField_a_of_type_Nlo.a.c, "", "", this.jdField_a_of_type_Nlo.a.b);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (a(paramContext, paramInt))
    {
      paramContext = String.valueOf(System.currentTimeMillis());
      if (jdField_a_of_type_ComTencentImageURLDrawable != null) {
        jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload();
      }
      jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString4, URLDrawable.URLDrawableOptions.obtain());
      if (jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) {
        a(paramContext, paramString1, paramString2, avdr.a(jdField_a_of_type_ComTencentImageURLDrawable), paramString3, paramInt);
      }
    }
    else
    {
      return;
    }
    if (jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "s_forShare Bitmap FAILED, downloadImediatly ...");
      }
      jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "start load URLDrawable. ...");
    }
    jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new asym(this, paramContext, paramString1, paramString2, paramString3, paramInt));
    jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, int paramInt)
  {
    if (paramInt == 1001)
    {
      WXShareHelper.a().b(paramString1, paramString2, paramBitmap, paramString3, paramString4);
      azqs.b(null, "dc00898", "", this.jdField_a_of_type_Nlo.a.a, "0X80092A3", "0X80092A3", 0, 0, this.jdField_a_of_type_Nlo.a.c, "", "", this.jdField_a_of_type_Nlo.a.b);
    }
    while (paramInt != 1002) {
      return;
    }
    WXShareHelper.a().a(paramString1, paramString2, paramBitmap, paramString3, paramString4);
    azqs.b(null, "dc00898", "", this.jdField_a_of_type_Nlo.a.a, "0X80092A5", "0X80092A5", 0, 0, this.jdField_a_of_type_Nlo.a.c, "", "", this.jdField_a_of_type_Nlo.a.b);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString4 = new azup(StructMsgForGeneralShare.class).c(127).b(12345).e(paramString4).a(alud.a(2131706133) + paramString3).a();
    Object localObject = this.jdField_a_of_type_Nlo.a.v;
    String str = this.jdField_a_of_type_Nlo.a.w;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString4.mSourceName = this.jdField_a_of_type_Nlo.a.v;
      if (!TextUtils.isEmpty(str)) {
        paramString4.mSourceIcon = this.jdField_a_of_type_Nlo.a.w;
      }
    }
    paramString4.mContentLayout = 2;
    localObject = azvc.a(2);
    ((azut)localObject).a(paramString1, paramString2, paramString3);
    paramString4.addItem((azus)localObject);
    paramString1 = new Intent();
    paramString1.putExtra("forward_type", -3);
    paramString1.putExtra("stuctmsg_bytes", paramString4.getBytes());
    paramString1.putExtra("structmsg_service_id", paramString4.mMsgServiceID);
    paramString1.putExtra("emoInputType", 2);
    paramString1.putExtra("forwardDirect", true);
    aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramString1, 1000);
    azqs.b(null, "dc00898", "", this.jdField_a_of_type_Nlo.a.a, "0X80092A2", "0X80092A2", 0, 0, this.jdField_a_of_type_Nlo.a.c, "", "", this.jdField_a_of_type_Nlo.a.b);
  }
  
  private boolean a(Context paramContext, int paramInt)
  {
    if (!WXShareHelper.a().a())
    {
      QQToast.a(paramContext, 2131694570, 0).a();
      return false;
    }
    if (!WXShareHelper.a().b())
    {
      QQToast.a(paramContext, 2131721492, 0).a();
      return false;
    }
    if ((paramInt == 1002) && (!WXShareHelper.a().c()))
    {
      QQToast.a(paramContext, 2131721492, 0).a();
      return false;
    }
    if (!bdin.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694768, 1).a();
      return false;
    }
    return true;
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed title==null");
      }
      bool = false;
    }
    for (;;)
    {
      if (!bool) {
        QQToast.a(paramContext, 2131718423, 0).a();
      }
      return bool;
      if (TextUtils.isEmpty(paramString2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed bitmapUrl==null");
        }
        bool = false;
      }
      else if (TextUtils.isEmpty(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed jumpUrl==null");
        }
        bool = false;
      }
    }
  }
  
  public ShareActionSheetBuilder.ActionSheetItem a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_AndroidContentContext.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.iconNeedBg = paramBoolean;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = paramString;
    return localActionSheetItem;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131720052));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=", localException);
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(2131696873, 2130838917, true, 2, ""));
    localArrayList.add(a(2131696886, 2130838918, true, 3, ""));
    localArrayList.add(a(2131696893, 2130838921, true, 9, ""));
    localArrayList.add(a(2131696876, 2130838915, true, 10, ""));
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = null;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      if ("onshare_ItemClick mAdItem " + this.jdField_a_of_type_Nlo == null)
      {
        paramAdapterView = " null";
        QLog.d("ImaxAdvertisement", 2, paramAdapterView);
      }
    }
    else
    {
      localObject2 = paramView.getTag();
      if ((localObject2 != null) && (this.jdField_a_of_type_Nlo != null)) {
        break label73;
      }
    }
    label73:
    String str2;
    Object localObject1;
    do
    {
      return;
      paramAdapterView = this.jdField_a_of_type_Nlo.toString();
      break;
      str2 = this.jdField_a_of_type_Nlo.a.x;
      paramView = this.jdField_a_of_type_Nlo.a.t;
      localObject1 = this.jdField_a_of_type_Nlo.a.s;
      String str1 = this.jdField_a_of_type_Nlo.a.u;
      paramAdapterView = paramView;
      if (TextUtils.isEmpty(paramView)) {
        paramAdapterView = this.jdField_a_of_type_Nlo.e;
      }
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = this.jdField_a_of_type_Nlo.d;
      }
      localObject1 = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject1 = this.jdField_a_of_type_Nlo.f;
      }
    } while (!a(this.jdField_a_of_type_AndroidContentContext, paramView, paramAdapterView, str2));
    switch (((bdmy)localObject2).a.action)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      return;
      a(paramAdapterView, paramView, (String)localObject1, str2);
      continue;
      a(this.jdField_a_of_type_AndroidContentContext, paramView, (String)localObject1, str2, paramAdapterView);
      continue;
      a(this.jdField_a_of_type_AndroidContentContext, paramView, (String)localObject1, str2, paramAdapterView, 1001);
      continue;
      a(this.jdField_a_of_type_AndroidContentContext, paramView, (String)localObject1, str2, paramAdapterView, 1002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyl
 * JD-Core Version:    0.7.0.1
 */