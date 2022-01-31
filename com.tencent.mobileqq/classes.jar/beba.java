import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class beba
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "inc";
  
  public beba(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    try
    {
      this.a = paramJSONObject.getString("name");
      this.b = paramJSONObject.getString("op");
      this.c = paramJSONObject.getString("val");
      this.d = paramJSONObject.getString("act");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return (!this.a.isEmpty()) && (!this.b.isEmpty()) && (!this.c.isEmpty());
  }
  
  public boolean a(Object paramObject)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        paramObject = beak.b(paramObject, this.a);
        if (paramObject == null) {
          break label668;
        }
        if ((paramObject.getClass() == Integer.TYPE) || (paramObject.getClass() == Integer.class) || (paramObject.getClass() == Long.TYPE) || (paramObject.getClass() == Long.class))
        {
          paramObject = (Integer)paramObject;
          if (this.b.equalsIgnoreCase("less"))
          {
            if (paramObject.intValue() >= Integer.parseInt(this.c)) {
              break label672;
            }
            bool1 = true;
            if (!this.d.equalsIgnoreCase("exc")) {
              break label660;
            }
            if (!bool1)
            {
              bool1 = bool2;
              break label670;
            }
          }
          else
          {
            if (this.b.equalsIgnoreCase("more"))
            {
              if (paramObject.intValue() <= Integer.parseInt(this.c)) {
                break label677;
              }
              bool1 = true;
              continue;
            }
            if (this.b.equalsIgnoreCase("is"))
            {
              if (paramObject.intValue() != Integer.parseInt(this.c)) {
                break label682;
              }
              bool1 = true;
              continue;
            }
            if (this.b.equalsIgnoreCase("not"))
            {
              if (paramObject.intValue() == Integer.parseInt(this.c)) {
                break label687;
              }
              bool1 = true;
              continue;
            }
            if (this.b.equalsIgnoreCase("and"))
            {
              if ((paramObject.intValue() & Integer.parseInt(this.c)) == 0) {
                break label692;
              }
              bool1 = true;
              continue;
            }
            if (this.b.equalsIgnoreCase("or"))
            {
              if ((paramObject.intValue() | Integer.parseInt(this.c)) == 0) {
                break label697;
              }
              bool1 = true;
              continue;
            }
            if (this.b.equalsIgnoreCase("xor"))
            {
              if ((paramObject.intValue() ^ Integer.parseInt(this.c)) == 0) {
                break label702;
              }
              bool1 = true;
              continue;
            }
            if (this.b.equalsIgnoreCase("begins"))
            {
              bool1 = String.format("%d", new Object[] { Integer.valueOf(paramObject.intValue()) }).startsWith(this.c);
              continue;
            }
            if (this.b.equalsIgnoreCase("ends"))
            {
              bool1 = String.format("%d", new Object[] { Integer.valueOf(paramObject.intValue()) }).endsWith(this.c);
              continue;
            }
            if (!this.b.equalsIgnoreCase("rem")) {
              break label663;
            }
            bool1 = Pattern.matches(this.c, String.format("%d", new Object[] { Integer.valueOf(paramObject.intValue()) }));
            continue;
          }
        }
        else
        {
          if ((paramObject.getClass() != String.class) && (paramObject.getClass() != CharSequence.class)) {
            break label663;
          }
          paramObject = (String)paramObject;
          if (this.b.equalsIgnoreCase("less"))
          {
            if (paramObject.compareToIgnoreCase(this.c) >= 0) {
              break label707;
            }
            bool1 = true;
            continue;
          }
          if (this.b.equalsIgnoreCase("more"))
          {
            if (paramObject.compareToIgnoreCase(this.c) <= 0) {
              break label712;
            }
            bool1 = true;
            continue;
          }
          if (this.b.equalsIgnoreCase("is"))
          {
            bool1 = paramObject.equalsIgnoreCase(this.c);
            continue;
          }
          if (this.b.equalsIgnoreCase("not"))
          {
            if (paramObject.equalsIgnoreCase(this.c)) {
              break label717;
            }
            bool1 = true;
            continue;
          }
          if (this.b.equalsIgnoreCase("has"))
          {
            bool1 = paramObject.contains(this.c);
            continue;
          }
          if (this.b.equalsIgnoreCase("begins"))
          {
            bool1 = paramObject.startsWith(this.c);
            continue;
          }
          if (this.b.equalsIgnoreCase("ends"))
          {
            bool1 = paramObject.endsWith(this.c);
            continue;
          }
          if (!this.b.equalsIgnoreCase("rem")) {
            break label663;
          }
          bool1 = Pattern.matches(this.c, paramObject);
          continue;
        }
        bool1 = false;
      }
      catch (Exception paramObject)
      {
        return false;
      }
      catch (IllegalArgumentException paramObject)
      {
        return false;
      }
      label660:
      break label670;
      label663:
      boolean bool1 = false;
      continue;
      label668:
      bool1 = false;
      label670:
      return bool1;
      label672:
      bool1 = false;
      continue;
      label677:
      bool1 = false;
      continue;
      label682:
      bool1 = false;
      continue;
      label687:
      bool1 = false;
      continue;
      label692:
      bool1 = false;
      continue;
      label697:
      bool1 = false;
      continue;
      label702:
      bool1 = false;
      continue;
      label707:
      bool1 = false;
      continue;
      label712:
      bool1 = false;
      continue;
      label717:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beba
 * JD-Core Version:    0.7.0.1
 */