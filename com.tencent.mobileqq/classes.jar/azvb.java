import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class azvb
  extends azqj
{
  private int k;
  
  public azvb()
  {
    this.a = "progress";
  }
  
  public azvb(int paramInt)
  {
    this.k = paramInt;
    this.a = "progress";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof ProgressBar))) {}
    for (paramContext = (ProgressBar)paramView;; paramContext = paramView)
    {
      paramContext.setTag(this);
      paramContext.setProgress(this.k);
      if (this.k == paramContext.getMax()) {
        paramContext.setVisibility(8);
      }
      return paramContext;
      paramView = new ProgressBar(paramContext, null, 16842872);
      paramView.setId(2131377064);
      paramView.setMax(100);
      paramView.setProgressDrawable(paramContext.getResources().getDrawable(2130837923));
    }
  }
  
  public String a()
  {
    return "Progress";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.k = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.k);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "progress");
    paramXmlSerializer.text(String.valueOf(this.k));
    paramXmlSerializer.endTag(null, "progress");
  }
  
  public boolean a(azsa paramazsa)
  {
    paramazsa = azqu.a(paramazsa);
    try
    {
      this.k = Integer.valueOf(paramazsa).intValue();
      return true;
    }
    catch (NumberFormatException paramazsa)
    {
      for (;;)
      {
        this.k = 0;
      }
    }
  }
  
  public int b()
  {
    return this.k;
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvb
 * JD-Core Version:    0.7.0.1
 */