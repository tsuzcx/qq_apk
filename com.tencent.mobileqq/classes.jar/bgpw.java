import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.widget.CylinderProgressView;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.OStatisticInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.RspBody;

public class bgpw
  implements BusinessObserver
{
  private final WeakReference<TroopMoreDetailView> a;
  
  public bgpw(TroopMoreDetailView paramTroopMoreDetailView)
  {
    this.a = new WeakReference(paramTroopMoreDetailView);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = (TroopMoreDetailView)this.a.get();
    if (localObject1 == null) {}
    label17:
    Object localObject2;
    Context localContext;
    int i;
    label137:
    View localView;
    StringBuffer localStringBuffer;
    do
    {
      do
      {
        break label17;
        break label17;
        for (;;)
        {
          return;
          if ((TroopMoreDetailView.a((TroopMoreDetailView)localObject1) != null) && (paramBoolean))
          {
            localObject2 = paramBundle.getByteArray("data");
            if (localObject2 == null) {
              break;
            }
            localContext = ((TroopMoreDetailView)localObject1).getContext();
            if (localContext == null) {
              break;
            }
            try
            {
              paramBundle = new troop_member_distribute.RspBody();
              paramBundle.mergeFrom((byte[])localObject2);
              if (paramBundle.uint32_result.get() == 0)
              {
                localObject2 = paramBundle.rpt_msg_statistic.get();
                i = paramBundle.uint32_group_member.get();
                if (i != 0) {
                  break label137;
                }
                if (QLog.isColorLevel())
                {
                  QLog.d("TroopMoreDetailView", 2, "mGetTroopMemberDistributeObserver.onReceive: memberCount should not be 0!");
                  return;
                }
              }
            }
            catch (InvalidProtocolBufferMicroException paramBundle) {}
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("TroopMoreDetailView", 2, paramBundle, new Object[0]);
      return;
      localView = localObject1.a[5];
      localStringBuffer = new StringBuffer(((TroopMoreDetailView)localObject1).getResources().getString(2131719651));
    } while ((localView == null) || (((List)localObject2).size() < 4));
    localView.setVisibility(0);
    if (localObject1.a[4] != null) {
      localObject1.a[4].setBackgroundResource(2130839503);
    }
    localStringBuffer.append(",本群共").append(i).append("人");
    paramBundle = localView.findViewById(2131379534);
    Typeface localTypeface = Typeface.createFromAsset(localContext.getAssets(), "fonts/qq_font_troop_member_number.ttf");
    paramInt = 0;
    Object localObject4;
    Object localObject3;
    if (paramInt < ((List)localObject2).size())
    {
      localObject1 = new int[2];
      localObject4 = (troop_member_distribute.OStatisticInfo)((List)localObject2).get(paramInt);
      localObject3 = ((troop_member_distribute.OStatisticInfo)localObject4).bytes_desc.get().toStringUtf8().split("-");
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      int j = ((troop_member_distribute.OStatisticInfo)localObject4).uint32_count.get() * 100 / i;
      localObject4 = (TextView)paramBundle.findViewById(2131380069);
      ((TextView)localObject4).setTextColor(localObject1[0]);
      ((TextView)localObject4).setTypeface(localTypeface);
      CylinderProgressView localCylinderProgressView = (CylinderProgressView)paramBundle.findViewById(2131376985);
      localCylinderProgressView.setProgressStartColor(localObject1[0]);
      localCylinderProgressView.setProgressEndColor(localObject1[1]);
      localCylinderProgressView.setMax(100);
      localCylinderProgressView.setProgress(j, (TextView)localObject4);
      localStringBuffer.append(", 百分之").append(j).append("为").append(localObject3[0]);
      ((TextView)paramBundle.findViewById(2131379001)).setText(localObject3[0]);
      ((TextView)paramBundle.findViewById(2131372158)).setText(localObject3[1]);
      localObject3 = (TextView)paramBundle.findViewById(2131380068);
      ((TextView)localObject3).setTextColor(localObject1[0]);
      ((TextView)localObject3).setTypeface(localTypeface);
      paramInt += 1;
      break;
      paramBundle = localView.findViewById(2131379534);
      localObject1 = CylinderProgressView.a();
      continue;
      paramBundle = localView.findViewById(2131379535);
      localObject1 = CylinderProgressView.a(localObject3[0].contains(localContext.getString(2131693752)));
      continue;
      paramBundle = localView.findViewById(2131379536);
      localObject1 = CylinderProgressView.b();
      continue;
      paramBundle = localView.findViewById(2131379537);
      localObject1 = CylinderProgressView.a(CylinderProgressView.a(localObject3[0]));
      continue;
      localView.setContentDescription(localStringBuffer);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpw
 * JD-Core Version:    0.7.0.1
 */