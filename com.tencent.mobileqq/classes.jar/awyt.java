import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class awyt
  extends awul
{
  String S = "";
  
  public awyt()
  {
    this.a = "more";
  }
  
  public awyt(String paramString)
  {
    this();
    this.S = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramView;
    if (paramView == null) {
      paramBundle = LayoutInflater.from(paramContext).inflate(2131496852, null);
    }
    paramContext = (TextView)paramBundle.findViewById(2131310783);
    if (TextUtils.isEmpty(this.S)) {
      this.S = ajjy.a(2131648824);
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
    for (String str = "";; str = awbk.a(this.S, false))
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
  
  public boolean a(awwc paramawwc)
  {
    this.S = awbk.a(awuw.a(paramawwc), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awyt
 * JD-Core Version:    0.7.0.1
 */