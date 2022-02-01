import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import org.xmlpull.v1.XmlSerializer;

public class bdsw
  extends bdnw
{
  public boolean c;
  public boolean d = true;
  public int o;
  public int p = 48;
  public int q = 1;
  public int r = 1;
  
  public bdsw()
  {
    this(null);
  }
  
  public bdsw(String paramString)
  {
    super(paramString, "td");
  }
  
  public TextView a(Context paramContext)
  {
    return new TextView(paramContext);
  }
  
  public String a()
  {
    return "td";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.r = paramObjectInput.readInt();
    this.p = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.r);
    paramObjectOutput.writeInt(this.p);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    paramXmlSerializer.attribute(null, "weight", String.valueOf(this.r));
    paramXmlSerializer.attribute(null, "align", String.valueOf(this.p));
    paramXmlSerializer.endTag(null, this.a);
    super.a(paramXmlSerializer);
  }
  
  public boolean a(bdpl parambdpl)
  {
    try
    {
      Object localObject = parambdpl.a("weight");
      if (localObject != null) {}
      for (int i = Integer.parseInt((String)localObject);; i = 0)
      {
        this.r = i;
        localObject = parambdpl.a("align");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split("\\|");
        HashMap localHashMap = new HashMap();
        localHashMap.put("left", Integer.valueOf(3));
        localHashMap.put("right", Integer.valueOf(5));
        localHashMap.put("top", Integer.valueOf(48));
        localHashMap.put("bottom", Integer.valueOf(80));
        localHashMap.put("center", Integer.valueOf(17));
        i = 0;
        while (i < localObject.length)
        {
          if (!TextUtils.isEmpty(localObject[i]))
          {
            String str = localObject[i].toLowerCase();
            if (localHashMap.containsKey(str))
            {
              int j = this.p;
              this.p = (((Integer)localHashMap.get(str)).intValue() | j);
            }
          }
          i += 1;
        }
      }
      return super.a(parambdpl);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.r = 1;
    }
  }
  
  public int b()
  {
    return this.q;
  }
  
  protected int c()
  {
    return 2131380183;
  }
  
  public int e()
  {
    if ((this.c) && (this.o != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int f()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsw
 * JD-Core Version:    0.7.0.1
 */