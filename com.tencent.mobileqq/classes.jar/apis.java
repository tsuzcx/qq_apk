import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import mqq.os.MqqHandler;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class apis
  extends aluu
{
  public apis(NearbyTransitActivity paramNearbyTransitActivity) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1)
  {
    apib.a("NearbyTransitActivity", new Object[] { "onJoinHotChat", Boolean.valueOf(NearbyTransitActivity.a(this.a)), Boolean.valueOf(paramBoolean), paramString1 });
    NearbyTransitActivity.a("onJoinHotChat", 1);
    if (NearbyTransitActivity.a(this.a)) {
      return;
    }
    NearbyTransitActivity.a(this.a).removeMessages(2);
    NearbyTransitActivity.a(this.a).removeMessages(5);
    if (this.a.jdField_a_of_type_Beub != null) {
      this.a.jdField_a_of_type_Beub.b();
    }
    paramBoolean1 = Message.obtain();
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString1))) {
      paramBoolean1.what = 3;
    }
    for (paramBoolean1.obj = new Object[] { paramString1, paramString2, paramString4 };; paramBoolean1.obj = paramString1)
    {
      NearbyTransitActivity.a(this.a).sendMessage(paramBoolean1);
      return;
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = NearbyTransitActivity.jdField_a_of_type_JavaLangString;
      }
      paramBoolean1.what = 1;
      paramBoolean1.arg1 = 11;
    }
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramHotChatInfo != null) {
        str = paramHotChatInfo.name;
      }
    }
    if ((NearbyTransitActivity.a(this.a) == 1) && (!bdeu.a(str, NearbyTransitActivity.a(this.a)))) {}
    do
    {
      return;
      NearbyTransitActivity.a("onQuickJoinHotChat", 1);
      apib.a("NearbyTransitActivity", new Object[] { "onQuickJoinHotChat", Boolean.valueOf(NearbyTransitActivity.a(this.a)), Boolean.valueOf(paramBoolean), Integer.valueOf(NearbyTransitActivity.a(this.a)), Integer.valueOf(paramInt), str, paramHotChatInfo, paramWifiPOIInfo });
    } while (NearbyTransitActivity.a(this.a));
    NearbyTransitActivity.a(this.a).removeMessages(2);
    NearbyTransitActivity.a(this.a).removeMessages(5);
    if (this.a.jdField_a_of_type_Beub != null) {
      this.a.jdField_a_of_type_Beub.b();
    }
    paramWifiPOIInfo = Message.obtain();
    if (paramBoolean) {
      if ((paramHotChatInfo != null) && ((paramInt == 1) || (paramInt == 2)))
      {
        paramWifiPOIInfo.what = 3;
        paramWifiPOIInfo.obj = new Object[] { paramHotChatInfo.troopUin, paramHotChatInfo.troopCode, paramHotChatInfo.name };
      }
    }
    while ((NearbyTransitActivity.b(this.a) == 1) && (paramWifiPOIInfo.what == 3) && (paramHotChatInfo.mFissionRoomNum > 0))
    {
      auwz.a("NearbyTransitActivity", new Object[] { "onQuickJoinHotChat allocate room success,is to showing entering tip " });
      paramString = Message.obtain();
      paramString.what = 5;
      paramString.obj = String.format(this.a.getResources().getString(2131693406), new Object[] { Integer.valueOf(paramHotChatInfo.mFissionRoomNum) });
      NearbyTransitActivity.a(this.a).sendMessage(paramString);
      NearbyTransitActivity.a(this.a).sendMessageDelayed(paramWifiPOIInfo, 600L);
      return;
      paramWifiPOIInfo.what = 1;
      paramWifiPOIInfo.arg1 = 5;
      paramWifiPOIInfo.obj = NearbyTransitActivity.jdField_a_of_type_JavaLangString;
      continue;
      paramWifiPOIInfo.what = 1;
      paramWifiPOIInfo.arg1 = (paramInt + 100);
      paramWifiPOIInfo.obj = auud.a(paramInt);
    }
    NearbyTransitActivity.a(this.a).sendMessage(paramWifiPOIInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apis
 * JD-Core Version:    0.7.0.1
 */