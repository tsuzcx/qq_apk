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

public class aolw
{
  private ArrayList<aogn> a = new ArrayList();
  
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
    return paramString + paramContext.getResources().getString(2131698960);
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public View a(Context paramContext, aogn paramaogn, ViewGroup paramViewGroup)
  {
    if (paramaogn == null) {}
    int i;
    do
    {
      return null;
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131560761, null);
      if (paramViewGroup == null) {
        break;
      }
      i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297151);
      if (paramaogn.a == null) {
        paramaogn.a = "";
      }
      paramContext = a(paramaogn.a, paramContext);
    } while (paramContext == null);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131377032);
    localTextView.setText(paramaogn.a);
    localTextView.setTextSize(0, i);
    localTextView.setText(paramContext);
    localTextView.setSingleLine(true);
    paramContext = (ImageView)paramViewGroup.findViewById(2131367679);
    if (paramaogn.a()) {
      paramContext.setBackgroundResource(2130844290);
    }
    paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-2, BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297148)));
    return paramViewGroup;
  }
  
  public aogn a(int paramInt)
  {
    return (aogn)this.a.get(paramInt);
  }
  
  public void a(ArrayList<aogn> paramArrayList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aolw
 * JD-Core Version:    0.7.0.1
 */