import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import org.xmlpull.v1.XmlSerializer;

public class awzg
  extends awun
{
  public boolean c;
  public boolean d = true;
  public int i;
  public int j = 48;
  public int k = 1;
  public int l = 1;
  
  public awzg()
  {
    this(null);
  }
  
  public awzg(String paramString)
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
    this.l = paramObjectInput.readInt();
    this.j = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.l);
    paramObjectOutput.writeInt(this.j);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    paramXmlSerializer.attribute(null, "weight", String.valueOf(this.l));
    paramXmlSerializer.attribute(null, "align", String.valueOf(this.j));
    paramXmlSerializer.endTag(null, this.a);
    super.a(paramXmlSerializer);
  }
  
  public boolean a(awwc paramawwc)
  {
    try
    {
      Object localObject = paramawwc.a("weight");
      if (localObject != null) {}
      for (int m = Integer.parseInt((String)localObject);; m = 0)
      {
        this.l = m;
        localObject = paramawwc.a("align");
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
        m = 0;
        while (m < localObject.length)
        {
          if (!TextUtils.isEmpty(localObject[m]))
          {
            String str = localObject[m].toLowerCase();
            if (localHashMap.containsKey(str))
            {
              int n = this.j;
              this.j = (((Integer)localHashMap.get(str)).intValue() | n);
            }
          }
          m += 1;
        }
      }
      return super.a(paramawwc);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.l = 1;
    }
  }
  
  public int b()
  {
    return this.k;
  }
  
  protected int c()
  {
    return 2131312537;
  }
  
  public int e()
  {
    if ((this.c) && (this.i != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int f()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awzg
 * JD-Core Version:    0.7.0.1
 */