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

public class bdau
  extends bdaq
{
  private String aq;
  private String ar;
  protected long c;
  protected long d;
  protected boolean d;
  protected long e;
  protected int q;
  protected int r;
  
  public bdau()
  {
    this.a = "timer";
  }
  
  private long a()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      long l1 = bbyp.a();
      long l2 = this.c + this.q - l1;
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
      } while (l2 < this.q);
      return this.q;
      this.jdField_d_of_type_Boolean = true;
      return l2;
    }
    return 0L;
  }
  
  private SpannableStringBuilder a(long paramLong)
  {
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-91585);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.aq);
    localSpannableStringBuilder.append('\n');
    if (paramLong > 0L)
    {
      int i = localSpannableStringBuilder.length();
      String str = String.valueOf(paramLong) + anni.a(2131713302);
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.append(this.ag);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan, i, str.length() + i, 33);
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(this.ar);
    return localSpannableStringBuilder;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof CountdownTextView)))
    {
      paramContext = (CountdownTextView)paramView;
      paramContext.a(a(), new bdav(this, paramContext));
      paramContext.setTag(this);
      return paramContext;
    }
    paramContext = new CountdownTextView(paramContext);
    paramContext.setId(2131379593);
    paramContext.setTag(this);
    paramContext.setMaxLines(3);
    paramContext.setTextColor(-10987432);
    paramContext.setTextSize(2, 12.0F);
    long l = a();
    if (this.ag != null) {
      paramContext.setText(a(l));
    }
    paramContext.a(l, new bdaw(this, paramContext));
    return paramContext;
  }
  
  public String a()
  {
    return "Timer";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.aq = bbzj.a(paramObjectInput.readUTF(), false);
    this.ar = bbzj.a(paramObjectInput.readUTF(), false);
    this.c = paramObjectInput.readLong();
    this.q = paramObjectInput.readInt();
    this.r = paramObjectInput.readInt();
    this.jdField_d_of_type_Long = paramObjectInput.readLong();
    this.e = paramObjectInput.readLong();
    this.jdField_d_of_type_Boolean = paramObjectInput.readBoolean();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.aq == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.ar != null) {
        break label108;
      }
    }
    label108:
    for (String str = "";; str = this.ar)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.c);
      paramObjectOutput.writeInt(this.q);
      paramObjectOutput.writeInt(this.r);
      paramObjectOutput.writeLong(this.jdField_d_of_type_Long);
      paramObjectOutput.writeLong(this.e);
      paramObjectOutput.writeBoolean(this.jdField_d_of_type_Boolean);
      return;
      str = this.aq;
      break;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "timer");
    paramXmlSerializer.attribute(null, "st", String.valueOf(this.c));
    paramXmlSerializer.attribute(null, "dr", String.valueOf(this.q));
    paramXmlSerializer.attribute(null, "index", String.valueOf(this.r));
    if (!TextUtils.isEmpty(this.aq)) {
      paramXmlSerializer.attribute(null, "summary", this.aq);
    }
    if (!TextUtils.isEmpty(this.ar)) {
      paramXmlSerializer.attribute(null, "ending", this.ar);
    }
    paramXmlSerializer.text(this.ag);
    paramXmlSerializer.endTag(null, "timer");
  }
  
  public boolean a(bcxj parambcxj)
  {
    if (parambcxj == null) {
      return true;
    }
    this.c = bcxm.a(parambcxj.a("st"));
    this.q = bcxm.a(parambcxj.a("dr"));
    this.r = bcxm.a(parambcxj.a("index"));
    this.aq = bbzj.a(parambcxj.a("summary"), false);
    this.ar = bbzj.a(parambcxj.a("st"), false);
    this.ag = bbzj.a(bcwd.a(parambcxj), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdau
 * JD-Core Version:    0.7.0.1
 */