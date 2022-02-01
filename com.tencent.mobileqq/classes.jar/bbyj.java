import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.Map;

class bbyj
  implements bljm
{
  bbyj(bbyf parambbyf) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    bhjs.a(true);
    SearchHistory localSearchHistory;
    label278:
    int i;
    if ((paramAdapterView == this.a.jdField_a_of_type_ComTencentWidgetXListView) && (this.a.jdField_a_of_type_Amnw != null))
    {
      bcni.a("home_page", "clk_history", new String[] { "" + paramInt });
      paramAdapterView = (bbzf)this.a.jdField_a_of_type_Amnw.getItem(paramInt);
      if (!(paramAdapterView instanceof bbya)) {
        break label1246;
      }
      localSearchHistory = ((bbya)paramAdapterView).a();
      QLog.d("searchUtils", 2, "on serarch history click, " + localSearchHistory.toString());
      switch (localSearchHistory.type)
      {
      default: 
        paramInt = 1;
        if (paramInt != 0)
        {
          bcni.a(bbyf.a(this.a), localSearchHistory.displayName, localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type);
          if (localSearchHistory.type != 1) {
            break label1171;
          }
          i = 2;
        }
        break;
      }
    }
    for (;;)
    {
      label324:
      paramInt = 0;
      if (this.a.b == 2)
      {
        paramInt = 3;
        label339:
        bdll.b(null, "CliOper", "", "", "Search", "May_find", paramInt, 0, String.valueOf(i), "", "", "");
        if (localSearchHistory.type != 0) {
          break label1221;
        }
        paramInt = 1;
      }
      for (;;)
      {
        bcjy.a(bbyf.a(this.a), 0, SearchEntryFragment.a(this.a.jdField_a_of_type_Int), "0X8009D19", paramInt, 0, null, null);
        return;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 29);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label278;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 34);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label278;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 53);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label278;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 53);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label278;
        ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(localSearchHistory.uin, 33);
        localAllInOne.a = new ArrayList();
        localAllInOne.k = localSearchHistory.displayName;
        if (!TextUtils.isEmpty(localSearchHistory.uin))
        {
          String[] arrayOfString = localSearchHistory.uin.split("\\|");
          if (arrayOfString != null)
          {
            paramInt = 0;
            if (paramInt < arrayOfString.length)
            {
              ArrayList localArrayList = localAllInOne.a;
              StringBuilder localStringBuilder = new StringBuilder().append(anzj.a(2131704382));
              if (arrayOfString.length > 0) {}
              for (paramAdapterView = Integer.valueOf(paramInt + 1);; paramAdapterView = "")
              {
                localArrayList.add(new ProfileActivity.CardContactInfo(paramAdapterView, arrayOfString[paramInt], null));
                paramInt += 1;
                break;
              }
            }
          }
        }
        localAllInOne.g = 3;
        ProfileActivity.b(paramView.getContext(), localAllInOne);
        paramInt = 1;
        break label278;
        paramAdapterView = (anyw)bbyf.a(this.a).getManager(51);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.e(localSearchHistory.uin);
          if (paramAdapterView != null)
          {
            alpb.a = true;
            alpb.a(paramView.getContext(), bbyf.a(this.a), localSearchHistory.uin, 0, bhlg.a(paramAdapterView), false);
          }
          paramInt = 1;
          break label278;
        }
        paramInt = 0;
        break label278;
        paramAdapterView = (anws)bbyf.a(this.a).getManager(53);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.a(localSearchHistory.troopUin);
          if (paramAdapterView != null)
          {
            paramAdapterView = (DiscussionMemberInfo)paramAdapterView.get(localSearchHistory.uin);
            if (paramAdapterView != null)
            {
              alpb.a = true;
              alpb.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, paramAdapterView.memberName, false);
              paramInt = 1;
              break label278;
            }
          }
        }
        alpb.a = true;
        alpb.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false);
        paramInt = 1;
        break label278;
        alpb.a = true;
        boolean bool = false;
        if ((paramView.getContext() instanceof UniteSearchActivity)) {
          bool = bbzx.a(localSearchHistory.uin);
        }
        if (!bool)
        {
          alpb.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false);
          paramInt = 1;
          break label278;
        }
        bgpy.a(paramView.getContext(), null, localSearchHistory.uin);
        paramInt = 1;
        break label278;
        alpb.a = true;
        alpb.a(paramView.getContext(), bbyf.a(this.a), localSearchHistory.uin, localSearchHistory.type, localSearchHistory.displayName, false);
        paramInt = 1;
        break label278;
        if (!TextUtils.equals(localSearchHistory.uin, antf.az)) {
          break;
        }
        ocd.a(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "", false);
        oix.a(paramView.getContext(), null, -1L, 1);
        paramInt = 1;
        break label278;
        ocd.a(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "", false);
        oix.a(bbyf.a(this.a), paramView.getContext(), 1, 0);
        break;
        label1171:
        if (localSearchHistory.type != 3000) {
          break label1251;
        }
        i = 3;
        break label324;
        if (this.a.b == 10)
        {
          paramInt = 2;
          break label339;
        }
        if (this.a.b != 1) {
          break label339;
        }
        paramInt = 1;
        break label339;
        label1221:
        if ((localSearchHistory.type == 1) || (localSearchHistory.type == 3000)) {
          paramInt = 2;
        } else {
          label1246:
          paramInt = 0;
        }
      }
      label1251:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyj
 * JD-Core Version:    0.7.0.1
 */