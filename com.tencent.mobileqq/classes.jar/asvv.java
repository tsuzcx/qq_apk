import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class asvv
{
  private ArrayList<asnt> a = new ArrayList();
  
  public static String a(String paramString, Context paramContext)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      paramString.replaceAll("\n|\r\n", " ");
      str = paramString;
    } while (paramString.length() <= 20);
    paramString = paramString.substring(0, 19);
    return paramString + paramContext.getResources().getString(2131698474);
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public View a(Context paramContext, asnt paramasnt, ViewGroup paramViewGroup)
  {
    if (paramasnt == null) {}
    int i;
    do
    {
      return null;
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131561146, null);
      if (paramViewGroup == null) {
        break;
      }
      i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297292);
      if (paramasnt.a == null) {
        paramasnt.a = "";
      }
      paramContext = a(paramasnt.a, paramContext);
    } while (paramContext == null);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131378658);
    localTextView.setText(paramasnt.a);
    localTextView.setTextSize(0, i);
    localTextView.setText(paramContext);
    localTextView.setSingleLine(true);
    paramContext = (ImageView)paramViewGroup.findViewById(2131368381);
    if (paramasnt.a()) {
      paramContext.setBackgroundResource(2130845084);
    }
    paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-2, BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297289)));
    return paramViewGroup;
  }
  
  public asnt a(int paramInt)
  {
    return (asnt)this.a.get(paramInt);
  }
  
  public void a(ArrayList<asnt> paramArrayList)
  {
    int i = 0;
    int j = 0;
    if ((paramArrayList == null) || (paramArrayList.size() < 1)) {}
    for (;;)
    {
      return;
      this.a.clear();
      if (paramArrayList.size() < 16)
      {
        i = j;
        while (i < 16)
        {
          j = paramArrayList.size();
          this.a.add(paramArrayList.get(i % j));
          i += 1;
        }
      }
      else
      {
        while (i < paramArrayList.size())
        {
          this.a.add(paramArrayList.get(i));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvv
 * JD-Core Version:    0.7.0.1
 */