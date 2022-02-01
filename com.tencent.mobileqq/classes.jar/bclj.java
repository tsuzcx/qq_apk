import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class bclj
  extends bcgw
{
  String ac = "";
  
  public bclj()
  {
    this.a = "more";
  }
  
  public bclj(String paramString)
  {
    this();
    this.ac = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramView;
    if (paramView == null) {
      paramBundle = LayoutInflater.from(paramContext).inflate(2131562825, null);
    }
    paramContext = (TextView)paramBundle.findViewById(2131377866);
    if (TextUtils.isEmpty(this.ac)) {
      this.ac = amtj.a(2131713650);
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
    for (String str = "";; str = bblk.a(this.ac, false))
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
  
  public boolean a(bcin parambcin)
  {
    this.ac = bblk.a(bchh.a(parambcin), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclj
 * JD-Core Version:    0.7.0.1
 */