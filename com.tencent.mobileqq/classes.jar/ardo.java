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
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import java.util.ArrayList;
import java.util.List;

public class ardo
  implements AdapterView.OnItemClickListener
{
  private static URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private Context jdField_a_of_type_AndroidContentContext;
  protected bbjq a;
  private nis jdField_a_of_type_Nis;
  
  public ardo(Context paramContext, nis paramnis)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Nis = paramnis;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.jdField_b_of_type_JavaLangString = paramString1;
    localQZoneShareData.c = paramString2;
    localQZoneShareData.a = new ArrayList();
    localQZoneShareData.a.add(paramString4);
    localQZoneShareData.d = paramString3;
    bgzl.a(paramContext, String.valueOf(bcyb.a().a()), localQZoneShareData, null, 1003);
    axqy.b(null, "dc00898", "", this.jdField_a_of_type_Nis.a.a, "0X80092A4", "0X80092A4", 0, 0, this.jdField_a_of_type_Nis.a.c, "", "", this.jdField_a_of_type_Nis.a.jdField_b_of_type_JavaLangString);
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
        a(paramContext, paramString1, paramString2, atij.a(jdField_a_of_type_ComTencentImageURLDrawable), paramString3, paramInt);
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
    jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new ardp(this, paramContext, paramString1, paramString2, paramString3, paramInt));
    jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, int paramInt)
  {
    if (paramInt == 1001)
    {
      WXShareHelper.a().b(paramString1, paramString2, paramBitmap, paramString3, paramString4);
      axqy.b(null, "dc00898", "", this.jdField_a_of_type_Nis.a.a, "0X80092A3", "0X80092A3", 0, 0, this.jdField_a_of_type_Nis.a.c, "", "", this.jdField_a_of_type_Nis.a.jdField_b_of_type_JavaLangString);
    }
    while (paramInt != 1002) {
      return;
    }
    WXShareHelper.a().a(paramString1, paramString2, paramBitmap, paramString3, paramString4);
    axqy.b(null, "dc00898", "", this.jdField_a_of_type_Nis.a.a, "0X80092A5", "0X80092A5", 0, 0, this.jdField_a_of_type_Nis.a.c, "", "", this.jdField_a_of_type_Nis.a.jdField_b_of_type_JavaLangString);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString4 = new axum(StructMsgForGeneralShare.class).c(127).b(12345).e(paramString4).a(ajya.a(2131705749) + paramString3).a();
    Object localObject = this.jdField_a_of_type_Nis.a.v;
    String str = this.jdField_a_of_type_Nis.a.w;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString4.mSourceName = this.jdField_a_of_type_Nis.a.v;
      if (!TextUtils.isEmpty(str)) {
        paramString4.mSourceIcon = this.jdField_a_of_type_Nis.a.w;
      }
    }
    paramString4.mContentLayout = 2;
    localObject = axuz.a(2);
    ((axuq)localObject).a(paramString1, paramString2, paramString3);
    paramString4.addItem((axup)localObject);
    paramString1 = new Intent();
    paramString1.putExtra("forward_type", -3);
    paramString1.putExtra("stuctmsg_bytes", paramString4.getBytes());
    paramString1.putExtra("structmsg_service_id", paramString4.mMsgServiceID);
    paramString1.putExtra("emoInputType", 2);
    paramString1.putExtra("forwardDirect", true);
    aqbe.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramString1, 1000);
    axqy.b(null, "dc00898", "", this.jdField_a_of_type_Nis.a.a, "0X80092A2", "0X80092A2", 0, 0, this.jdField_a_of_type_Nis.a.c, "", "", this.jdField_a_of_type_Nis.a.jdField_b_of_type_JavaLangString);
  }
  
  private boolean a(Context paramContext, int paramInt)
  {
    if (!WXShareHelper.a().a())
    {
      bcql.a(paramContext, 2131694411, 0).a();
      return false;
    }
    if (!WXShareHelper.a().b())
    {
      bcql.a(paramContext, 2131720918, 0).a();
      return false;
    }
    if ((paramInt == 1002) && (!WXShareHelper.a().c()))
    {
      bcql.a(paramContext, 2131720918, 0).a();
      return false;
    }
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694610, 1).a();
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
        bcql.a(paramContext, 2131718036, 0).a();
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
  
  public bbjs a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString)
  {
    bbjs localbbjs = new bbjs();
    localbbjs.a = this.jdField_a_of_type_AndroidContentContext.getString(paramInt1);
    localbbjs.jdField_b_of_type_Int = paramInt2;
    localbbjs.jdField_b_of_type_Boolean = paramBoolean;
    localbbjs.c = paramInt3;
    localbbjs.jdField_b_of_type_JavaLangString = paramString;
    return localbbjs;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbjq == null)
    {
      this.jdField_a_of_type_Bbjq = new bbjq(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bbjq.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719508));
      this.jdField_a_of_type_Bbjq.a(a());
      this.jdField_a_of_type_Bbjq.a(this);
    }
    try
    {
      this.jdField_a_of_type_Bbjq.a();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=", localException);
    }
  }
  
  public List<bbjs>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(2131696696, 2130838754, true, 2, ""));
    localArrayList.add(a(2131696709, 2130838755, true, 3, ""));
    localArrayList.add(a(2131696716, 2130838758, true, 9, ""));
    localArrayList.add(a(2131696699, 2130838752, true, 10, ""));
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Bbjq = null;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      if ("onshare_ItemClick mAdItem " + this.jdField_a_of_type_Nis == null)
      {
        paramAdapterView = " null";
        QLog.d("ImaxAdvertisement", 2, paramAdapterView);
      }
    }
    else
    {
      localObject2 = paramView.getTag();
      if ((localObject2 != null) && (this.jdField_a_of_type_Nis != null)) {
        break label73;
      }
    }
    label73:
    String str2;
    Object localObject1;
    do
    {
      return;
      paramAdapterView = this.jdField_a_of_type_Nis.toString();
      break;
      str2 = this.jdField_a_of_type_Nis.a.x;
      paramView = this.jdField_a_of_type_Nis.a.t;
      localObject1 = this.jdField_a_of_type_Nis.a.s;
      String str1 = this.jdField_a_of_type_Nis.a.u;
      paramAdapterView = paramView;
      if (TextUtils.isEmpty(paramView)) {
        paramAdapterView = this.jdField_a_of_type_Nis.e;
      }
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = this.jdField_a_of_type_Nis.d;
      }
      localObject1 = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject1 = this.jdField_a_of_type_Nis.f;
      }
    } while (!a(this.jdField_a_of_type_AndroidContentContext, paramView, paramAdapterView, str2));
    switch (((bbjv)localObject2).a.c)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbjq.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ardo
 * JD-Core Version:    0.7.0.1
 */