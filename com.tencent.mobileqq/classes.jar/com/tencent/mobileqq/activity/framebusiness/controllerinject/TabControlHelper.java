package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.widget.TabHost.TabSpec;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQTabHost;
import java.util.ArrayList;
import java.util.HashMap;

public class TabControlHelper
{
  private static volatile TabControlHelper a;
  private HashMap<String, BaseTabControl> b = new HashMap();
  
  private TabControlHelper()
  {
    this.b.put("CONVERSATION", new ConversationControl());
    this.b.put("GUILD", new GuildControl());
    this.b.put("NEW_WORLD", new NewWorldControl());
    this.b.put("CONTACT", new ContactControl());
    this.b.put("RIJ", new RIJControl());
    this.b.put("LEBA", new LebaControl());
  }
  
  public static TabControlHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TabControlHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  public BaseTabControl a(String paramString)
  {
    return (BaseTabControl)this.b.get(paramString);
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    if ((paramFrameFragment != null) && (paramFrameFragment.s != null) && (paramFrameFragment.u != null) && (paramFrameFragment.getContext() != null) && (paramFrameFragment.getQBaseActivity() != null))
    {
      if (paramFrameFragment.v == null) {
        return;
      }
      String[] arrayOfString = TabDataHelper.transferConfigStringToArray(TabDataHelper.getTabRuleList(paramFrameFragment.getContext(), paramFrameFragment.getQBaseActivity().getCurrentAccountUinFromRuntime(), TabDataHelper.getModelType()));
      int i = 0;
      while (i < arrayOfString.length)
      {
        BaseTabControl localBaseTabControl = a().a(arrayOfString[i]);
        if (localBaseTabControl != null)
        {
          int j = 0;
          while (j < paramFrameFragment.u.size())
          {
            TabHost.TabSpec localTabSpec = (TabHost.TabSpec)paramFrameFragment.u.get(j);
            if ((localTabSpec != null) && (localBaseTabControl.a(localTabSpec.getTag())))
            {
              paramFrameFragment.s.addTab(localTabSpec);
              paramFrameFragment.v.add(localTabSpec);
              break;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.TabControlHelper
 * JD-Core Version:    0.7.0.1
 */