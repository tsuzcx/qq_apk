package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import org.json.JSONException;
import org.json.JSONObject;

class EcshopNewPageFragment$4
  extends BroadcastReceiver
{
  EcshopNewPageFragment$4(EcshopNewPageFragment paramEcshopNewPageFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 8;
    int i = 0;
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!"com.tencent.biz.pubaccount.ecshop.tabpage.finish".equals(paramContext)) {
        break label45;
      }
      if (this.a.getActivity() != null) {
        this.a.getActivity().finish();
      }
    }
    label45:
    label188:
    label193:
    do
    {
      int k;
      int m;
      do
      {
        do
        {
          return;
        } while (!"action_notify_view_update".equals(paramContext));
        k = paramIntent.getIntExtra("businessId", 0);
        m = paramIntent.getIntExtra("viewId", 0);
      } while ((25 != k) || (m != 1));
      for (;;)
      {
        try
        {
          paramContext = new JSONObject(paramIntent.getStringExtra("extstr"));
          if (!"top".equals(EcshopNewPageFragment.a(this.a))) {
            break label193;
          }
          if (EcshopNewPageFragment.a(this.a) == null) {
            break;
          }
          paramIntent = EcshopNewPageFragment.a(this.a);
          if (paramContext.optInt("isShow") == 1)
          {
            i = 0;
            paramIntent.setVisibility(i);
            paramIntent = EcshopNewPageFragment.a(this.a);
            if (paramContext.optInt("isShow") != 1) {
              break label188;
            }
            i = j;
            paramIntent.setVisibility(i);
            return;
          }
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        i = 8;
        continue;
        i = 0;
      }
    } while (EcshopNewPageFragment.a(this.a) == null);
    paramIntent = EcshopNewPageFragment.a(this.a);
    if (paramContext.optInt("isShow") == 1) {}
    for (;;)
    {
      paramIntent.setVisibility(i);
      return;
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment.4
 * JD-Core Version:    0.7.0.1
 */