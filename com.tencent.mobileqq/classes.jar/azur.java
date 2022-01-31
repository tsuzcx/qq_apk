import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class azur
  extends azqj
{
  String S = "";
  
  public azur()
  {
    this.a = "more";
  }
  
  public azur(String paramString)
  {
    this();
    this.S = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramView;
    if (paramView == null) {
      paramBundle = LayoutInflater.from(paramContext).inflate(2131562655, null);
    }
    paramContext = (TextView)paramBundle.findViewById(2131377081);
    if (TextUtils.isEmpty(this.S)) {
      this.S = alpo.a(2131714996);
    }
    paramContext.setText(this.S);
    return paramBundle;
  }
  
  public String a()
  {
    return "More";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.S = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.S == null) {}
    for (String str = "";; str = ayvy.a(this.S, false))
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "title");
    paramXmlSerializer.text(this.S);
    paramXmlSerializer.endTag(null, "title");
  }
  
  public boolean a(azsa paramazsa)
  {
    this.S = ayvy.a(azqu.a(paramazsa), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azur
 * JD-Core Version:    0.7.0.1
 */