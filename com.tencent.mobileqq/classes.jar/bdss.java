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

public class bdss
  extends bdsv
{
  private String as;
  
  public bdss()
  {
    this.a = "price";
  }
  
  public bdss(String paramString)
  {
    this();
    this.ai = paramString;
  }
  
  public bdss(String paramString1, String paramString2)
  {
    this(paramString1);
    this.as = paramString2;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramContext = (LinearLayout)paramView;
      ((TextView)paramContext.findViewById(2131380083)).setText(this.ai);
      ((TextView)paramContext.findViewById(2131380085)).setText(this.as);
      return paramContext;
    }
    paramView = new LinearLayout(paramContext);
    paramView.setOrientation(0);
    paramBundle = new TextView(paramContext);
    paramBundle.setId(2131380083);
    paramBundle.setText(this.ai);
    paramBundle.setTextColor(-65536);
    paramBundle.setTextSize(14.0F);
    paramBundle.setSingleLine();
    paramBundle.setEllipsize(a());
    paramBundle.setGravity(3);
    paramContext = new TextView(paramContext);
    paramContext.setId(2131380085);
    paramContext.setText(this.as);
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
    this.as = bcsc.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.as == null) {}
    for (String str = "";; str = this.as)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "price");
    if (!TextUtils.isEmpty(this.as)) {
      paramXmlSerializer.attribute(null, "unit", this.as);
    }
    paramXmlSerializer.text(this.ai);
    paramXmlSerializer.endTag(null, "price");
  }
  
  public boolean a(bdpl parambdpl)
  {
    if (parambdpl == null) {
      return true;
    }
    this.as = bcsc.a(parambdpl.a("unit"), false);
    this.ai = bcsc.a(bdof.a(parambdpl), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdss
 * JD-Core Version:    0.7.0.1
 */