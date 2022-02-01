package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

public class MovieTicketTipsBar
  implements TipsBarTask
{
  private Context a;
  private View b;
  private TextView c;
  private ImageView d;
  private String e;
  
  public MovieTicketTipsBar(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public int a()
  {
    return 66;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.b == null)
    {
      this.b = LayoutInflater.from(this.a).inflate(2131624148, null);
      this.c = ((TextView)this.b.findViewById(2131428137));
      this.d = ((ImageView)this.b.findViewById(2131428136));
      this.d.setImageResource(2130849232);
      this.b.setOnClickListener(new MovieTicketTipsBar.1(this));
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof String))) {
      paramVarArgs = new String(Base64.decode((String)paramVarArgs[0], 0));
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs);
      String str = paramVarArgs.getString("content");
      this.c.setText(str);
      this.e = paramVarArgs.getString("url");
      label150:
      return this.b;
    }
    catch (JSONException paramVarArgs)
    {
      break label150;
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public int b()
  {
    return 17;
  }
  
  public int[] c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.MovieTicketTipsBar
 * JD-Core Version:    0.7.0.1
 */