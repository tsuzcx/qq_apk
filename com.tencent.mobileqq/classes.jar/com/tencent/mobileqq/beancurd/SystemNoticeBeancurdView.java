package com.tencent.mobileqq.beancurd;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForBeancurd;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SystemNoticeBeancurdView
  extends BeancurdView
{
  private TextView j;
  private TextView k;
  private ImageView l;
  private ImageView m;
  private BoxShadowLayout n;
  
  public SystemNoticeBeancurdView(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
    a();
  }
  
  private void a()
  {
    this.j = ((TextView)this.a.findViewById(2131448814));
    this.k = ((TextView)this.a.findViewById(2131448296));
    this.l = ((ImageView)this.a.findViewById(2131434906));
    this.m = ((ImageView)this.a.findViewById(2131434922));
  }
  
  protected View a(Context paramContext)
  {
    return View.inflate(paramContext, 2131627329, null);
  }
  
  public View a(MessageForBeancurd paramMessageForBeancurd)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    a(this.j, paramMessageForBeancurd.getDescription());
    a(this.k, paramMessageForBeancurd.getContentList());
    a((BaseQQAppInterface)localAppRuntime, paramMessageForBeancurd.getUinList());
    return this.n;
  }
  
  protected void a(AppInterface paramAppInterface, List<String> paramList)
  {
    a(paramAppInterface, this.m, (String)paramList.get(0));
    if (paramList.size() > 1) {
      a(paramAppInterface, this.l, (String)paramList.get(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.beancurd.SystemNoticeBeancurdView
 * JD-Core Version:    0.7.0.1
 */