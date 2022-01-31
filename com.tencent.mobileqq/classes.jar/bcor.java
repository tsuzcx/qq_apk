import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.ui.RoundProgressBar;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.OStatisticInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.RspBody;

public class bcor
  implements BusinessObserver
{
  private final WeakReference<TroopMoreDetailView> a;
  
  public bcor(TroopMoreDetailView paramTroopMoreDetailView)
  {
    this.a = new WeakReference(paramTroopMoreDetailView);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.a.get();
    if (localTroopMoreDetailView == null) {}
    Object localObject2;
    Context localContext;
    int j;
    label141:
    View localView;
    StringBuffer localStringBuffer;
    do
    {
      do
      {
        for (;;)
        {
          return;
          localObject1 = TroopMoreDetailView.a(localTroopMoreDetailView);
          if ((localObject1 != null) && (paramBoolean))
          {
            localObject2 = paramBundle.getByteArray("data");
            if (localObject2 != null)
            {
              localContext = localTroopMoreDetailView.getContext();
              if (localContext != null) {
                try
                {
                  paramBundle = new troop_member_distribute.RspBody();
                  paramBundle.mergeFrom((byte[])localObject2);
                  if (paramBundle.uint32_result.get() == 0)
                  {
                    localObject2 = paramBundle.rpt_msg_statistic.get();
                    j = paramBundle.uint32_group_member.get();
                    if (j != 0) {
                      break label141;
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
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("TroopMoreDetailView", 2, paramBundle, new Object[0]);
      return;
      localView = localTroopMoreDetailView.a[5];
      localStringBuffer = new StringBuffer(localTroopMoreDetailView.getResources().getString(2131721076));
    } while ((localView == null) || (((List)localObject2).size() < 4));
    localView.setVisibility(0);
    if (localTroopMoreDetailView.a[4] != null) {
      localTroopMoreDetailView.a[4].setBackgroundResource(2130839260);
    }
    localStringBuffer.append(",本群共").append(j).append("人");
    paramBundle = localView.findViewById(2131378389);
    paramBoolean = ThemeUtil.isInNightMode((AppRuntime)localObject1);
    int i = 0;
    label300:
    Object localObject3;
    RoundProgressBar localRoundProgressBar;
    if (i < ((List)localObject2).size())
    {
      paramInt = Color.parseColor("#ffffff00");
      switch (i)
      {
      case 0: 
        localObject3 = (troop_member_distribute.OStatisticInfo)((List)localObject2).get(i);
        localRoundProgressBar = (RoundProgressBar)paramBundle.findViewById(2131376017);
        localRoundProgressBar.setTextColor(localContext.getResources().getColor(2131166904));
        if (!paramBoolean) {
          break;
        }
      }
    }
    for (Object localObject1 = "#FF1F1F1F";; localObject1 = "#FFDDDDDD")
    {
      localRoundProgressBar.setCircleColor(Color.parseColor((String)localObject1));
      localRoundProgressBar.setRoundWidth(aekt.a(2.0F, localTroopMoreDetailView.getResources()));
      localRoundProgressBar.setTextSize(34.0F);
      localRoundProgressBar.setCircleProgressColor(paramInt);
      paramInt = ((troop_member_distribute.OStatisticInfo)localObject3).uint32_count.get() * 100 / j;
      localRoundProgressBar.setProgress(paramInt);
      localObject1 = (TextView)paramBundle.findViewById(2131377884);
      localObject3 = ((troop_member_distribute.OStatisticInfo)localObject3).bytes_desc.get().toStringUtf8();
      ((TextView)localObject1).setText((CharSequence)localObject3);
      localObject1 = ((String)localObject3).split("-");
      localStringBuffer.append(", 百分之").append(paramInt).append("为").append(localObject1[0]);
      i += 1;
      break;
      localObject1 = localView.findViewById(2131378389);
      if (paramBoolean)
      {
        paramBundle = "#FF371657";
        label496:
        paramInt = Color.parseColor(paramBundle);
        paramBundle = (Bundle)localObject1;
        break label300;
        localObject1 = localView.findViewById(2131378390);
        if (!paramBoolean) {
          break label605;
        }
        paramBundle = "#FF17470A";
        label523:
        paramInt = Color.parseColor(paramBundle);
        paramBundle = (Bundle)localObject1;
        break label300;
        localObject1 = localView.findViewById(2131378391);
        if (!paramBoolean) {
          break label611;
        }
        paramBundle = "#FF074861";
        label550:
        paramInt = Color.parseColor(paramBundle);
        paramBundle = (Bundle)localObject1;
        break label300;
        localObject1 = localView.findViewById(2131378392);
        if (!paramBoolean) {
          break label618;
        }
      }
      label605:
      label611:
      label618:
      for (paramBundle = "#FF615400";; paramBundle = "#ffff8400")
      {
        paramInt = Color.parseColor(paramBundle);
        paramBundle = (Bundle)localObject1;
        break;
        localView.setContentDescription(localStringBuffer);
        return;
        break;
        paramBundle = "#ff771bf4";
        break label496;
        paramBundle = "#ff0eddb8";
        break label523;
        paramBundle = "#ff0d8aff";
        break label550;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcor
 * JD-Core Version:    0.7.0.1
 */