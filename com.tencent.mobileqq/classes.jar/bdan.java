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

public class bdan
  extends bdaq
{
  private String aq;
  
  public bdan()
  {
    this.a = "price";
  }
  
  public bdan(String paramString)
  {
    this();
    this.ag = paramString;
  }
  
  public bdan(String paramString1, String paramString2)
  {
    this(paramString1);
    this.aq = paramString2;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramContext = (LinearLayout)paramView;
      ((TextView)paramContext.findViewById(2131379820)).setText(this.ag);
      ((TextView)paramContext.findViewById(2131379822)).setText(this.aq);
      return paramContext;
    }
    paramView = new LinearLayout(paramContext);
    paramView.setOrientation(0);
    paramBundle = new TextView(paramContext);
    paramBundle.setId(2131379820);
    paramBundle.setText(this.ag);
    paramBundle.setTextColor(-65536);
    paramBundle.setTextSize(14.0F);
    paramBundle.setSingleLine();
    paramBundle.setEllipsize(a());
    paramBundle.setGravity(3);
    paramContext = new TextView(paramContext);
    paramContext.setId(2131379822);
    paramContext.setText(this.aq);
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
    this.aq = bbzj.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.aq == null) {}
    for (String str = "";; str = this.aq)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "price");
    if (!TextUtils.isEmpty(this.aq)) {
      paramXmlSerializer.attribute(null, "unit", this.aq);
    }
    paramXmlSerializer.text(this.ag);
    paramXmlSerializer.endTag(null, "price");
  }
  
  public boolean a(bcxj parambcxj)
  {
    if (parambcxj == null) {
      return true;
    }
    this.aq = bbzj.a(parambcxj.a("unit"), false);
    this.ag = bbzj.a(bcwd.a(parambcxj), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdan
 * JD-Core Version:    0.7.0.1
 */