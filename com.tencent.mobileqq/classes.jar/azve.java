import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import org.xmlpull.v1.XmlSerializer;

public class azve
  extends azql
{
  public boolean c;
  public boolean d = true;
  public int k;
  public int l = 48;
  public int m = 1;
  public int n = 1;
  
  public azve()
  {
    this(null);
  }
  
  public azve(String paramString)
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
    this.n = paramObjectInput.readInt();
    this.l = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.n);
    paramObjectOutput.writeInt(this.l);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    paramXmlSerializer.attribute(null, "weight", String.valueOf(this.n));
    paramXmlSerializer.attribute(null, "align", String.valueOf(this.l));
    paramXmlSerializer.endTag(null, this.a);
    super.a(paramXmlSerializer);
  }
  
  public boolean a(azsa paramazsa)
  {
    try
    {
      Object localObject = paramazsa.a("weight");
      if (localObject != null) {}
      for (int i = Integer.parseInt((String)localObject);; i = 0)
      {
        this.n = i;
        localObject = paramazsa.a("align");
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
              int j = this.l;
              this.l = (((Integer)localHashMap.get(str)).intValue() | j);
            }
          }
          i += 1;
        }
      }
      return super.a(paramazsa);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.n = 1;
    }
  }
  
  public int b()
  {
    return this.m;
  }
  
  protected int c()
  {
    return 2131378960;
  }
  
  public int e()
  {
    if ((this.c) && (this.k != 0)) {
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
 * Qualified Name:     azve
 * JD-Core Version:    0.7.0.1
 */