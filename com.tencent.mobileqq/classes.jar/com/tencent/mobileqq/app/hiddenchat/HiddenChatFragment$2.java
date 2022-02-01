package com.tencent.mobileqq.app.hiddenchat;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class HiddenChatFragment$2
  extends TroopCommonlyUsedObserver
{
  HiddenChatFragment$2(HiddenChatFragment paramHiddenChatFragment) {}
  
  public void a(int paramInt1, int paramInt2, Map<String, Integer> paramMap, String paramString)
  {
    paramString = this.a.getBaseActivity();
    String str1 = HiddenChatFragment.a(this.a).getCurrentAccountUin();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramInt1 = 0;
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        paramInt2 = ((Integer)paramMap.get(str2)).intValue();
        if (paramInt2 == 4000) {
          SharedPreUtils.h(paramString, str1, str2);
        } else if (paramInt2 != 0) {
          paramInt1 = 1;
        }
      }
      if (paramInt1 == 0) {
        SharedPreUtils.j(this.a.getBaseActivity(), HiddenChatFragment.a(this.a).getCurrentAccountUin());
      }
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 != 0)
    {
      paramString1 = paramString2;
      if (!this.a.getActivity().isFinishing())
      {
        paramString1 = paramString2;
        if (!"troop_delete_top_from_conversation".equals(paramString3))
        {
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = this.a.getResources().getString(2131694666);
          }
          QQToast.a(this.a.getBaseActivity(), 1, paramString1, 0).a();
        }
      }
    }
    else
    {
      this.a.a();
      paramString1 = paramString2;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("onSetCommonUsedTroop, retCode = ");
      paramString2.append(paramInt2);
      paramString2.append(" , wording = ");
      paramString2.append(paramString1);
      QLog.d("tag_hidden_chat", 2, paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment.2
 * JD-Core Version:    0.7.0.1
 */