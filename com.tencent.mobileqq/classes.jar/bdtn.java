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

public class bdtn
  extends bdtj
{
  private String as;
  private String at;
  protected long c;
  protected long d;
  protected boolean d;
  protected long e;
  protected int q;
  protected int r;
  
  public bdtn()
  {
    this.a = "timer";
  }
  
  private long a()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      long l1 = bcrg.a();
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
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.as);
    localSpannableStringBuilder.append('\n');
    if (paramLong > 0L)
    {
      int i = localSpannableStringBuilder.length();
      String str = String.valueOf(paramLong) + anzj.a(2131713411);
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.append(this.ai);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan, i, str.length() + i, 33);
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(this.at);
    return localSpannableStringBuilder;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof CountdownTextView)))
    {
      paramContext = (CountdownTextView)paramView;
      paramContext.a(a(), new bdto(this, paramContext));
      paramContext.setTag(this);
      return paramContext;
    }
    paramContext = new CountdownTextView(paramContext);
    paramContext.setId(2131379766);
    paramContext.setTag(this);
    paramContext.setMaxLines(3);
    paramContext.setTextColor(-10987432);
    paramContext.setTextSize(2, 12.0F);
    long l = a();
    if (this.ai != null) {
      paramContext.setText(a(l));
    }
    paramContext.a(l, new bdtp(this, paramContext));
    return paramContext;
  }
  
  public String a()
  {
    return "Timer";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.as = bcsa.a(paramObjectInput.readUTF(), false);
    this.at = bcsa.a(paramObjectInput.readUTF(), false);
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
    if (this.as == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.at != null) {
        break label108;
      }
    }
    label108:
    for (String str = "";; str = this.at)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.c);
      paramObjectOutput.writeInt(this.q);
      paramObjectOutput.writeInt(this.r);
      paramObjectOutput.writeLong(this.jdField_d_of_type_Long);
      paramObjectOutput.writeLong(this.e);
      paramObjectOutput.writeBoolean(this.jdField_d_of_type_Boolean);
      return;
      str = this.as;
      break;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "timer");
    paramXmlSerializer.attribute(null, "st", String.valueOf(this.c));
    paramXmlSerializer.attribute(null, "dr", String.valueOf(this.q));
    paramXmlSerializer.attribute(null, "index", String.valueOf(this.r));
    if (!TextUtils.isEmpty(this.as)) {
      paramXmlSerializer.attribute(null, "summary", this.as);
    }
    if (!TextUtils.isEmpty(this.at)) {
      paramXmlSerializer.attribute(null, "ending", this.at);
    }
    paramXmlSerializer.text(this.ai);
    paramXmlSerializer.endTag(null, "timer");
  }
  
  public boolean a(bdqc parambdqc)
  {
    if (parambdqc == null) {
      return true;
    }
    this.c = bdqf.a(parambdqc.a("st"));
    this.q = bdqf.a(parambdqc.a("dr"));
    this.r = bdqf.a(parambdqc.a("index"));
    this.as = bcsa.a(parambdqc.a("summary"), false);
    this.at = bcsa.a(parambdqc.a("st"), false);
    this.ai = bcsa.a(bdow.a(parambdqc), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtn
 * JD-Core Version:    0.7.0.1
 */