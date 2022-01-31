import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class awzc
  extends awzf
{
  private String ai;
  
  public awzc()
  {
    this.a = "price";
  }
  
  public awzc(String paramString)
  {
    this();
    this.Y = paramString;
  }
  
  public awzc(String paramString1, String paramString2)
  {
    this(paramString1);
    this.ai = paramString2;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramContext = (LinearLayout)paramView;
      ((TextView)paramContext.findViewById(2131312461)).setText(this.Y);
      ((TextView)paramContext.findViewById(2131312463)).setText(this.ai);
      return paramContext;
    }
    paramView = new LinearLayout(paramContext);
    paramView.setOrientation(0);
    paramBundle = new TextView(paramContext);
    paramBundle.setId(2131312461);
    paramBundle.setText(this.Y);
    paramBundle.setTextColor(-65536);
    paramBundle.setTextSize(14.0F);
    paramBundle.setSingleLine();
    paramBundle.setEllipsize(a());
    paramBundle.setGravity(3);
    paramContext = new TextView(paramContext);
    paramContext.setId(2131312463);
    paramContext.setText(this.ai);
    paramContext.setSingleLine();
    paramContext.setEllipsize(a());
    paramContext.setTextSize(10.0F);
    paramContext.setTextColor(-65536);
    paramContext.setGravity(80);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(5, 0, 0, 0);
    paramContext.setLayoutParams(localLayoutParams);
    paramView.addView(paramBundle);
    paramView.addView(paramContext);
    paramView.setTag(this);
    return paramView;
  }
  
  public String a()
  {
    return "Price";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ai = awbk.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.ai == null) {}
    for (String str = "";; str = this.ai)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "price");
    if (!TextUtils.isEmpty(this.ai)) {
      paramXmlSerializer.attribute(null, "unit", this.ai);
    }
    paramXmlSerializer.text(this.Y);
    paramXmlSerializer.endTag(null, "price");
  }
  
  public boolean a(awwc paramawwc)
  {
    if (paramawwc == null) {
      return true;
    }
    this.ai = awbk.a(paramawwc.a("unit"), false);
    this.Y = awbk.a(awuw.a(paramawwc), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awzc
 * JD-Core Version:    0.7.0.1
 */