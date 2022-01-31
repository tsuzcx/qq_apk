import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class avpe
  extends avpc
{
  public static final String k = avpe.class.getSimpleName();
  public boolean b;
  public boolean c;
  public String l;
  public String m;
  public String n;
  
  protected avpe(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, UnifySearchCommon.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramInt1, paramJSONObject, paramInt2, paramResultItem);
  }
  
  protected avpe(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, DynamicSearch.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramInt1, paramJSONObject, paramInt2, paramResultItem);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    avwf.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.n);
  }
  
  public void a(avxi paramavxi)
  {
    if (!(paramavxi instanceof avxk)) {
      return;
    }
    int i = paramavxi.a().getLayoutParams().width - azvv.a(paramavxi.a().getContext(), 3.0F);
    if (this.jdField_a_of_type_Avox != null) {
      avsh.a(this, paramavxi, true, i);
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramavxi.a().setTextColor(Color.parseColor("#737373"));
      paramavxi.c().setTextColor(Color.parseColor("#4A4A4A"));
      if (!TextUtils.isEmpty(this.l)) {
        break label192;
      }
      paramavxi.a().setVisibility(8);
      label104:
      if (!TextUtils.isEmpty(this.m)) {
        break label254;
      }
      paramavxi.c().setVisibility(8);
      label123:
      if (!this.jdField_b_of_type_Boolean) {
        break label276;
      }
      paramavxi.a().setGravity(1);
      paramavxi.c().setGravity(1);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.n)) {
        break label295;
      }
      paramavxi.a().setOnClickListener(null);
      return;
      paramavxi.a().setTextColor(Color.parseColor("#262626"));
      paramavxi.c().setTextColor(Color.parseColor("#737373"));
      break;
      label192:
      paramavxi.a().setVisibility(0);
      if (this.c)
      {
        paramavxi.a().setText(avwf.a(paramavxi.a(), i, 2, this.l, this.jdField_a_of_type_Avvu.a, false, false));
        break label104;
      }
      paramavxi.a().setText(this.l);
      break label104;
      label254:
      paramavxi.c().setVisibility(0);
      paramavxi.c().setText(this.m);
      break label123;
      label276:
      paramavxi.a().setGravity(3);
      paramavxi.c().setGravity(3);
    }
    label295:
    paramavxi.a().setOnClickListener(this);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    this.l = paramJSONObject.optString("title");
    this.m = paramJSONObject.optString("desc");
    if (paramJSONObject.optInt("needCenter") == 1)
    {
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      this.n = paramJSONObject.optString("jumpUrl");
      if (paramJSONObject.optInt("highlightTitle", 1) != 1) {
        break label109;
      }
    }
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.c = bool1;
      this.j = paramJSONObject.optString("result_id");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("extra_report_info");
      paramJSONObject = paramJSONObject.optJSONObject("imageInfo");
      if (paramJSONObject == null) {
        break label114;
      }
      a(paramJSONObject);
      return;
      bool1 = false;
      break;
    }
    label114:
    this.jdField_a_of_type_Avox = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpe
 * JD-Core Version:    0.7.0.1
 */