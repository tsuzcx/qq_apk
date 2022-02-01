import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class bdsj
  extends bdnu
{
  String ac = "";
  
  public bdsj()
  {
    this.a = "more";
  }
  
  public bdsj(String paramString)
  {
    this();
    this.ac = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramView;
    if (paramView == null) {
      paramBundle = LayoutInflater.from(paramContext).inflate(2131562896, null);
    }
    paramContext = (TextView)paramBundle.findViewById(2131378152);
    if (TextUtils.isEmpty(this.ac)) {
      this.ac = anvx.a(2131713997);
    }
    paramContext.setText(this.ac);
    return paramBundle;
  }
  
  public String a()
  {
    return "More";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ac = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.ac == null) {}
    for (String str = "";; str = bcsc.a(this.ac, false))
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "title");
    paramXmlSerializer.text(this.ac);
    paramXmlSerializer.endTag(null, "title");
  }
  
  public boolean a(bdpl parambdpl)
  {
    this.ac = bcsc.a(bdof.a(parambdpl), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsj
 * JD-Core Version:    0.7.0.1
 */