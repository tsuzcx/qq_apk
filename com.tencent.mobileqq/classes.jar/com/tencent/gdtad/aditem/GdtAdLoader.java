package com.tencent.gdtad.aditem;

import android.content.Context;
import com.tencent.gdtad.net.GdtHttp;
import com.tencent.gdtad.net.GdtHttp.Listener;
import com.tencent.gdtad.net.GdtHttp.Params;
import com.tencent.gdtad.util.GdtDeviceUtil;
import java.lang.ref.WeakReference;
import qpg;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class GdtAdLoader
{
  private GdtAdLoader.Session jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session;
  private GdtHttp.Listener jdField_a_of_type_ComTencentGdtadNetGdtHttp$Listener = new qpg(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public GdtAdLoader(GdtAdLoader.Session paramSession, WeakReference paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session = paramSession;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((GdtAdLoader.Listener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this);
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public GdtAdLoader.Session a()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session;
  }
  
  public void a(Context paramContext)
  {
    if ((paramContext == null) || (this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session == null) || (!this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session.a())) {}
    do
    {
      a();
      return;
      paramContext = GdtDeviceUtil.a(paramContext);
      if (paramContext != null) {
        this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session.a.device_info.set(paramContext);
      }
      paramContext = new GdtHttp.Params();
      paramContext.a("https://mi.gdt.qq.com/rpc/gdt.display.QQAdService.GetAds");
      paramContext.jdField_a_of_type_JavaLangString = "POST";
      paramContext.b = "application/x-protobuf";
      paramContext.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session.a.toByteArray();
    } while (!paramContext.a());
    GdtHttp.a(paramContext, new WeakReference(this.jdField_a_of_type_ComTencentGdtadNetGdtHttp$Listener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader
 * JD-Core Version:    0.7.0.1
 */