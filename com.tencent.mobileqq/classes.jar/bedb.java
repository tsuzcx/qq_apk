import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;
import java.util.ArrayList;
import java.util.Collections;

public class bedb
  extends becy
{
  public bedb(VipFunCallPreviewActivity paramVipFunCallPreviewActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    Collections.sort(this.a.jdField_a_of_type_JavaUtilArrayList);
    this.a.d = this.a.jdField_a_of_type_JavaUtilArrayList.toString();
    this.a.a(false, 0);
    this.a.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject1;
    int i;
    int j;
    String str;
    Object localObject2;
    Object localObject3;
    if (!paramBoolean)
    {
      localObject1 = (Bundle)paramObject;
      i = ((Bundle)localObject1).getInt("result");
      j = ((Bundle)localObject1).getInt("callId", this.a.jdField_a_of_type_Int);
      paramObject = ((Bundle)localObject1).getString("message");
      str = ((Bundle)localObject1).getString("svr_url");
      localObject2 = ((Bundle)localObject1).getString("svr_actStr");
      if (i != 9002) {
        break label290;
      }
      paramInt = 11;
      localObject3 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject3 = alud.a(2131717140);
      }
      paramObject = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label607;
      }
      localObject1 = alud.a(2131717118);
      localObject2 = null;
      paramInt = 11;
      paramObject = localObject3;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramObject)) {
        if ((i == 22001) || (i == 6002))
        {
          paramObject = alud.a(2131717134);
          label222:
          VipFunCallPreviewActivity localVipFunCallPreviewActivity = this.a;
          localObject3 = localObject1;
          if (!TextUtils.isEmpty(str))
          {
            localObject3 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject3 = alud.a(2131717138);
            }
          }
          localVipFunCallPreviewActivity.a(paramInt, j, null, paramObject, (String)localObject2, (String)localObject3, str);
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(50);
          return;
          label290:
          if (i == 9003)
          {
            paramInt = 12;
            localObject1 = paramObject;
            if (TextUtils.isEmpty(paramObject)) {
              localObject1 = alud.a(2131717121);
            }
            paramObject = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label607;
            }
            localObject3 = alud.a(2131717133);
            localObject2 = null;
            paramInt = 12;
            paramObject = localObject1;
            localObject1 = localObject3;
            continue;
          }
          if ((i == 1005011) || (i == 5002))
          {
            paramInt = 2;
            localObject1 = paramObject;
            if (TextUtils.isEmpty(paramObject)) {
              localObject1 = alud.a(2131717127);
            }
            paramObject = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label607;
            }
            localObject3 = alud.a(2131717131);
            localObject2 = null;
            paramInt = 2;
            paramObject = localObject1;
            localObject1 = localObject3;
            continue;
          }
          if ((i == 1005012) || (i == 4002))
          {
            paramInt = 1;
            localObject1 = paramObject;
            if (TextUtils.isEmpty(paramObject)) {
              localObject1 = alud.a(2131717136);
            }
            paramObject = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label607;
            }
            localObject3 = alud.a(2131717128);
            localObject2 = null;
            paramInt = 1;
            paramObject = localObject1;
            localObject1 = localObject3;
            continue;
          }
          if (i == 461001)
          {
            localObject1 = alud.a(2131717143);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label601;
            }
          }
        }
      }
      label601:
      for (paramObject = alud.a(2131717137);; paramObject = localObject2)
      {
        localObject3 = alud.a(2131717126);
        str = bdtg.a("funCallMine");
        paramInt = 6;
        localObject2 = localObject1;
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject2 = localObject3;
        break;
        localObject3 = null;
        localObject1 = localObject2;
        paramInt = 4;
        localObject2 = localObject3;
        break;
        if (i == 3002)
        {
          paramObject = alud.a(2131717117);
          break label222;
        }
        if (i == 8002)
        {
          paramObject = alud.a(2131717144);
          break label222;
        }
        break label222;
      }
      label607:
      localObject3 = null;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedb
 * JD-Core Version:    0.7.0.1
 */