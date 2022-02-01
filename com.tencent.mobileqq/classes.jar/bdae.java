import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class bdae
  extends bcvs
{
  String aa = "";
  
  public bdae()
  {
    this.a = "more";
  }
  
  public bdae(String paramString)
  {
    this();
    this.aa = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramView;
    if (paramView == null) {
      paramBundle = LayoutInflater.from(paramContext).inflate(2131562912, null);
    }
    paramContext = (TextView)paramBundle.findViewById(2131377942);
    if (TextUtils.isEmpty(this.aa)) {
      this.aa = anni.a(2131713309);
    }
    paramContext.setText(this.aa);
    return paramBundle;
  }
  
  public String a()
  {
    return "More";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.aa = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.aa == null) {}
    for (String str = "";; str = bbzj.a(this.aa, false))
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "title");
    paramXmlSerializer.text(this.aa);
    paramXmlSerializer.endTag(null, "title");
  }
  
  public boolean a(bcxj parambcxj)
  {
    this.aa = bbzj.a(bcwd.a(parambcxj), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdae
 * JD-Core Version:    0.7.0.1
 */