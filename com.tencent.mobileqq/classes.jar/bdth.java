import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class bdth
  extends bdol
{
  private int o;
  
  public bdth()
  {
    this.a = "progress";
  }
  
  public bdth(int paramInt)
  {
    this.o = paramInt;
    this.a = "progress";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof ProgressBar))) {}
    for (paramContext = (ProgressBar)paramView;; paramContext = paramView)
    {
      paramContext.setTag(this);
      paramContext.setProgress(this.o);
      if (this.o == paramContext.getMax()) {
        paramContext.setVisibility(8);
      }
      return paramContext;
      paramView = new ProgressBar(paramContext, null, 16842872);
      paramView.setId(2131378079);
      paramView.setMax(100);
      paramView.setProgressDrawable(paramContext.getResources().getDrawable(2130838027));
    }
  }
  
  public String a()
  {
    return "Progress";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.o = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.o);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "progress");
    paramXmlSerializer.text(String.valueOf(this.o));
    paramXmlSerializer.endTag(null, "progress");
  }
  
  public boolean a(bdqc parambdqc)
  {
    parambdqc = bdow.a(parambdqc);
    try
    {
      this.o = Integer.valueOf(parambdqc).intValue();
      return true;
    }
    catch (NumberFormatException parambdqc)
    {
      for (;;)
      {
        this.o = 0;
      }
    }
  }
  
  public int b()
  {
    return this.o;
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdth
 * JD-Core Version:    0.7.0.1
 */