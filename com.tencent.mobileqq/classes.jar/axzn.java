import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class axzn
  extends axzj
{
  private String ai;
  private String aj;
  protected long c;
  protected long d;
  protected boolean d;
  protected long e;
  protected int m;
  protected int n;
  
  public axzn()
  {
    this.a = "timer";
  }
  
  private long a()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      long l1 = awzy.a();
      long l2 = this.c + this.m - l1;
      if (l2 < 0L)
      {
        this.jdField_d_of_type_Boolean = true;
        l1 = 0L;
      }
      do
      {
        return l1;
        if (l2 <= 0L) {
          break;
        }
        l1 = l2;
      } while (l2 < this.m);
      return this.m;
      this.jdField_d_of_type_Boolean = true;
      return l2;
    }
    return 0L;
  }
  
  private SpannableStringBuilder a(long paramLong)
  {
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-91585);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.ai);
    localSpannableStringBuilder.append('\n');
    if (paramLong > 0L)
    {
      int i = localSpannableStringBuilder.length();
      String str = String.valueOf(paramLong) + ajya.a(2131714617);
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.append(this.Y);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan, i, str.length() + i, 33);
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(this.aj);
    return localSpannableStringBuilder;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof CountdownTextView)))
    {
      paramContext = (CountdownTextView)paramView;
      paramContext.a(a(), new axzo(this, paramContext));
      paramContext.setTag(this);
      return paramContext;
    }
    paramContext = new CountdownTextView(paramContext);
    paramContext.setId(2131378117);
    paramContext.setTag(this);
    paramContext.setMaxLines(3);
    paramContext.setTextColor(-10987432);
    paramContext.setTextSize(2, 12.0F);
    long l = a();
    if (this.Y != null) {
      paramContext.setText(a(l));
    }
    paramContext.a(l, new axzp(this, paramContext));
    return paramContext;
  }
  
  public String a()
  {
    return "Timer";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ai = axau.a(paramObjectInput.readUTF(), false);
    this.aj = axau.a(paramObjectInput.readUTF(), false);
    this.c = paramObjectInput.readLong();
    this.m = paramObjectInput.readInt();
    this.n = paramObjectInput.readInt();
    this.jdField_d_of_type_Long = paramObjectInput.readLong();
    this.e = paramObjectInput.readLong();
    this.jdField_d_of_type_Boolean = paramObjectInput.readBoolean();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.ai == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.aj != null) {
        break label108;
      }
    }
    label108:
    for (String str = "";; str = this.aj)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.c);
      paramObjectOutput.writeInt(this.m);
      paramObjectOutput.writeInt(this.n);
      paramObjectOutput.writeLong(this.jdField_d_of_type_Long);
      paramObjectOutput.writeLong(this.e);
      paramObjectOutput.writeBoolean(this.jdField_d_of_type_Boolean);
      return;
      str = this.ai;
      break;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "timer");
    paramXmlSerializer.attribute(null, "st", String.valueOf(this.c));
    paramXmlSerializer.attribute(null, "dr", String.valueOf(this.m));
    paramXmlSerializer.attribute(null, "index", String.valueOf(this.n));
    if (!TextUtils.isEmpty(this.ai)) {
      paramXmlSerializer.attribute(null, "summary", this.ai);
    }
    if (!TextUtils.isEmpty(this.aj)) {
      paramXmlSerializer.attribute(null, "ending", this.aj);
    }
    paramXmlSerializer.text(this.Y);
    paramXmlSerializer.endTag(null, "timer");
  }
  
  public boolean a(axwg paramaxwg)
  {
    if (paramaxwg == null) {
      return true;
    }
    this.c = axwj.a(paramaxwg.a("st"));
    this.m = axwj.a(paramaxwg.a("dr"));
    this.n = axwj.a(paramaxwg.a("index"));
    this.ai = axau.a(paramaxwg.a("summary"), false);
    this.aj = axau.a(paramaxwg.a("st"), false);
    this.Y = axau.a(axva.a(paramaxwg), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axzn
 * JD-Core Version:    0.7.0.1
 */