package com.tencent.biz.pubaccount.weishi_new.profile.header;

import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi_new.jump.OnJumpListener;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileBeaconReport;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/profile/header/WSProfileHeaderUtils$onJump$1", "Lcom/tencent/biz/pubaccount/weishi_new/jump/OnJumpListener;", "onJumpMiniApp", "", "onJumpWSClient", "onJumpWebH5", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSProfileHeaderUtils$onJump$1
  extends OnJumpListener
{
  WSProfileHeaderUtils$onJump$1(String paramString1, String paramString2, stSimpleMetaPerson paramstSimpleMetaPerson) {}
  
  public void a()
  {
    super.a();
    String str1 = this.a;
    String str2 = this.b;
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((stSimpleMetaPerson)localObject).id;
    } else {
      localObject = null;
    }
    WSProfileBeaconReport.a(str1, str2, (String)localObject, 1000003);
  }
  
  public void b()
  {
    super.b();
    String str1 = this.a;
    String str2 = this.b;
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((stSimpleMetaPerson)localObject).id;
    } else {
      localObject = null;
    }
    WSProfileBeaconReport.a(str1, str2, (String)localObject, 1000007);
  }
  
  public void c()
  {
    super.c();
    String str1 = this.a;
    String str2 = this.b;
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((stSimpleMetaPerson)localObject).id;
    } else {
      localObject = null;
    }
    WSProfileBeaconReport.a(str1, str2, (String)localObject, 1000004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.header.WSProfileHeaderUtils.onJump.1
 * JD-Core Version:    0.7.0.1
 */