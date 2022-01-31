import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class axzh
  extends axup
{
  private int k;
  
  public axzh()
  {
    this.a = "progress";
  }
  
  public axzh(int paramInt)
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
      paramView.setId(2131376564);
      paramView.setMax(100);
      paramView.setProgressDrawable(paramContext.getResources().getDrawable(2130837727));
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
  
  public boolean a(axwg paramaxwg)
  {
    paramaxwg = axva.a(paramaxwg);
    try
    {
      this.k = Integer.valueOf(paramaxwg).intValue();
      return true;
    }
    catch (NumberFormatException paramaxwg)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axzh
 * JD-Core Version:    0.7.0.1
 */