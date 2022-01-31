import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class avkm
  extends avkj
  implements azwh, begh
{
  protected int a;
  private avtp jdField_a_of_type_Avtp = new avtp();
  private azwg jdField_a_of_type_Azwg;
  private begh jdField_a_of_type_Begh;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  public int b = -1;
  
  public avkm(ListView paramListView, azwg paramazwg, begh parambegh, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Azwg = paramazwg;
    paramazwg.a(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_Begh = parambegh;
    this.b = paramInt;
  }
  
  private avth a(int paramInt)
  {
    avol localavol = a(paramInt);
    if (localavol == null) {
      return null;
    }
    if (!(localavol instanceof avth)) {
      return null;
    }
    return (avth)localavol;
  }
  
  private void a(int paramInt, View paramView, avol paramavol)
  {
    if ((paramView == null) || (paramavol == null)) {}
    for (;;)
    {
      return;
      if ((paramavol instanceof avpt))
      {
        paramView = (avwx)paramView.getTag(2131313378);
        if ((paramView instanceof avtj)) {}
        for (paramView = ((avtj)paramView).a(); paramView != null; paramView = null)
        {
          this.jdField_a_of_type_Avtp.a(paramInt, paramView);
          return;
        }
      }
    }
  }
  
  private boolean a(View paramView, avol paramavol)
  {
    if ((paramView == null) || (paramavol == null)) {
      return false;
    }
    if ((paramavol instanceof avpt))
    {
      avwx localavwx = (avwx)paramView.getTag(2131313378);
      paramView = null;
      if ((localavwx instanceof avtj)) {
        paramView = ((avtj)localavwx).a();
      }
      if (paramView == null) {
        return false;
      }
      if ((((avpt)paramavol).f() != paramView.c()) || (((avpt)paramavol).h() != paramView.b())) {
        break label100;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "reuse contentview");
      }
    }
    return true;
    label100:
    return false;
  }
  
  private boolean a(View paramView, avol paramavol, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      if (paramView == null) {
        break label203;
      }
      paramView = (avwx)paramView.getTag(2131313378);
      if (!(paramView instanceof avtj)) {
        break label71;
      }
      paramView = (avtj)paramView;
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof avtt)))
      {
        if (paramInt1 != 0) {
          break label76;
        }
        ((avtt)paramView).a(false);
      }
      for (;;)
      {
        if ((paramInt1 < 1) || (paramInt3 != 59))
        {
          label68:
          return paramBoolean;
          label71:
          paramView = null;
          break;
          label76:
          if (paramInt1 == 1)
          {
            localObject = a(paramInt1 - 1);
            if ((!(localObject instanceof avnu)) || (((avnu)localObject).jdField_a_of_type_Boolean)) {
              break label197;
            }
          }
        }
      }
      label167:
      label197:
      for (Object localObject = ((avnu)localObject).a().a();; localObject = null)
      {
        if ((paramavol != null) && (localObject != null) && (((List)localObject).contains(paramavol))) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label167;
          }
          ((avtt)paramView).a(false);
          break;
        }
        break;
        paramView = a(paramInt1 - 1);
        if ((!(paramView instanceof avtf)) || (((avtf)paramView).a() != 1)) {
          break label68;
        }
        return true;
      }
      label203:
      paramView = null;
    }
  }
  
  public int a(int paramInt)
  {
    if ((a(paramInt) instanceof avnk)) {
      return ((avnk)a(paramInt)).b();
    }
    if ((a(paramInt) instanceof avnl)) {
      return ((avnl)a(paramInt)).d();
    }
    return 0;
  }
  
  protected avri a(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 28: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 37: 
    case 43: 
    case 58: 
    default: 
      return new avsc(this.jdField_a_of_type_Azwg);
    case 41: 
      return new avrg(this.jdField_a_of_type_Azwg);
    case 3: 
      return new avry(this.jdField_a_of_type_Azwg, false);
    case 12: 
      return new avry(this.jdField_a_of_type_Azwg, true);
    case 57: 
      return new avrc();
    case 0: 
      return new avsd();
    case 49: 
      return new avrw();
    case 15: 
      return new avsd();
    case 2: 
    case 8: 
      return new avrr(this.jdField_a_of_type_Azwg);
    case 9: 
      return new avsa();
    case 14: 
      return new avsa();
    case 10: 
      return new bfii();
    case 11: 
      return new aoon(this.jdField_a_of_type_Azwg);
    case 13: 
      return new avqt(this.jdField_a_of_type_Azwg);
    case 56: 
      return new avrj(this.jdField_a_of_type_Azwg);
    case 60: 
      return new avrn(this.jdField_a_of_type_Azwg);
    case 16: 
      return new avsc(this.jdField_a_of_type_Azwg);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new avqo(this.jdField_a_of_type_Azwg, a(paramInt), this);
    case 29: 
    case 30: 
    case 36: 
      return new avrd();
    case 38: 
    case 39: 
    case 42: 
    case 44: 
    case 45: 
    case 47: 
    case 48: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 61: 
    case 62: 
      return new avsh(this.jdField_a_of_type_Azwg, this);
    case 46: 
      return new avrs(this.jdField_a_of_type_Azwg);
    }
    return new avrt(this.jdField_a_of_type_Azwg, this);
  }
  
  protected avwx a(int paramInt, ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    Object localObject1;
    switch (getItemViewType(paramInt))
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 18: 
    case 20: 
    case 28: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 37: 
    case 43: 
    case 58: 
    default: 
      return new avyl(paramViewGroup, 2131496770);
    case 41: 
      return new avwt(paramViewGroup);
    case 3: 
      return new avyh(paramViewGroup);
    case 12: 
      return new avyf(paramViewGroup);
    case 57: 
      return new avwr(paramViewGroup);
    case 0: 
    case 15: 
      localObject1 = a(paramInt);
      if (!(localObject1 instanceof avnu)) {
        break;
      }
    }
    for (boolean bool1 = ((avnu)localObject1).a();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new avyj(paramViewGroup, bool2, bool1);
      return new avyl(paramViewGroup, 2131493882);
      return new avyg(paramViewGroup);
      return new avyi(paramViewGroup, 2131496791, 2130845098, -1);
      return new avyi(paramViewGroup, 2131496791, 2130845098, 12);
      return new avym(paramViewGroup, 2131494073);
      return new avwo(paramViewGroup, 2131496774);
      return new avwy(paramViewGroup, 2131496776);
      return new avxa(paramViewGroup, 2131496777);
      return new avwn(paramViewGroup, 2131496820);
      return new avyl(paramViewGroup, 2131496771);
      return new avyl(paramViewGroup, 2131496778);
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = avtr.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (avol)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof avpt))) {
        ((avpt)localObject1).c(((avth)localObject2).b());
      }
      if (localObject2 == null) {
        return new avwr(paramViewGroup);
      }
      return ((avth)localObject2).a();
      return new avye(paramViewGroup, a(paramInt));
      localObject1 = a(paramInt);
      if ((localObject1 instanceof avpw)) {
        return new avyd(paramViewGroup, ((avpw)localObject1).d());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject1 = a(paramInt);
      if ((localObject1 instanceof avow))
      {
        localObject1 = (avow)localObject1;
        switch (((avow)localObject1).d())
        {
        case 5: 
        case 10: 
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((avow)localObject1).e() + " which is not supported!!!");
        case 2: 
          return new avxb(paramViewGroup, ((avow)localObject1).e());
        case 3: 
          return new avxx(paramViewGroup, ((avow)localObject1).e());
        case 4: 
          return new avxc(paramViewGroup, ((avow)localObject1).e());
        case 7: 
          return new avxj(paramViewGroup, ((avow)localObject1).e());
        case 6: 
          return new avxw(paramViewGroup, ((avow)localObject1).e());
        case 8: 
          return new avxu(paramViewGroup, ((avow)localObject1).e());
        case 9: 
          return new avxt(paramViewGroup, ((avow)localObject1).e());
        case 11: 
          return new avxg(paramViewGroup, ((avow)localObject1).e());
        case 12: 
          return new avxe(paramViewGroup, ((avow)localObject1).e());
        case 13: 
          return new avxh(paramViewGroup, ((avow)localObject1).e());
        case 14: 
          return new avxv(paramViewGroup, ((avow)localObject1).e());
        case 15: 
          return new avxr(paramViewGroup, ((avow)localObject1).e());
        case 16: 
          return new avxm(paramViewGroup, ((avow)localObject1).e());
        case 17: 
          return new avxo(paramViewGroup, ((avow)localObject1).e());
        }
        return new avxl(paramViewGroup, ((avow)localObject1).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new avym(paramViewGroup, 2131493883);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 12;
    if ((super.a(paramInt) instanceof avnw)) {
      i = 41;
    }
    do
    {
      return i;
      if ((super.a(paramInt) instanceof avoa)) {
        return 3;
      }
    } while ((super.a(paramInt) instanceof avmf));
    if (((super.a(paramInt) instanceof avnu)) && (this.b != 12))
    {
      if (((avnu)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof avnu)) && (this.b == 12))
    {
      if (((avnu)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof avnv))
    {
      avnv localavnv = (avnv)super.a(paramInt);
      if ((localavnv != null) && (localavnv.jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof avof)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof avno)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof avob)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof avns)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof avod)) {
      return 60;
    }
    if ((super.a(paramInt) instanceof avnq)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof avnm)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof avoc)) && (this.b != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof avoc)) && (this.b == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof bfim)) {
      return 10;
    }
    if ((a(paramInt) instanceof aooq)) {
      return 11;
    }
    if (((super.a(paramInt) instanceof avnx)) || ((super.a(paramInt) instanceof avnz))) {
      return 13;
    }
    if ((a(paramInt) instanceof avoe)) {
      return 17;
    }
    if ((a(paramInt) instanceof avny)) {
      return 19;
    }
    if ((a(paramInt) instanceof avpt)) {
      return 59;
    }
    if ((a(paramInt) instanceof avnl))
    {
      switch (((avnl)a(paramInt)).d())
      {
      default: 
        return 25;
      case 268435456: 
        return 26;
      case 1001: 
        return 21;
      }
      return 22;
    }
    if ((a(paramInt) instanceof avpw))
    {
      switch (((avpw)a(paramInt)).jdField_a_of_type_Int)
      {
      case -2: 
      default: 
        return 29;
      case -1: 
        return 29;
      case -3: 
        return 30;
      }
      return 36;
    }
    if ((a(paramInt) instanceof avow))
    {
      switch (((avow)a(paramInt)).d())
      {
      case 5: 
      case 10: 
      default: 
        return 45;
      case 2: 
        return 38;
      case 3: 
        return 39;
      case 4: 
        return 42;
      case 7: 
        return 44;
      case 6: 
        return 45;
      case 8: 
        return 47;
      case 9: 
        return 48;
      case 11: 
        return 50;
      case 12: 
        return 51;
      case 13: 
        return 52;
      case 14: 
        return 53;
      case 15: 
        return 54;
      case 16: 
        return 55;
      case 17: 
        return 61;
      }
      return 62;
    }
    if ((a(paramInt) instanceof avpr)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    avol localavol = a(paramInt);
    Object localObject3;
    int j;
    Object localObject6;
    Object localObject7;
    Object localObject2;
    if (avjb.a(localavol) > 0)
    {
      Object localObject1;
      if (avjb.b.containsKey(localavol))
      {
        localObject1 = (avjc)avjb.b.get(localavol);
        if (!((avjc)localObject1).jdField_a_of_type_Boolean)
        {
          ((avjc)localObject1).jdField_a_of_type_Boolean = true;
          localObject3 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject3).put("project", avsv.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("get_src", "native");
        ((JSONObject)localObject3).put("obj_lct", ((avjc)localObject1).jdField_a_of_type_Int);
        localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        avsv.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((avjc)localObject1).jdField_a_of_type_Long + "").obj2(((avjc)localObject1).jdField_b_of_type_JavaLangString).ver1(((avjc)localObject1).jdField_a_of_type_JavaLangString).ver2(avsv.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
        ((avjc)localObject1).jdField_a_of_type_Boolean = true;
        avjb.b.put(localavol, localObject1);
        if ((localavol instanceof avom))
        {
          localObject1 = (avom)localavol;
          localObject3 = ((avom)localObject1).a();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            j = Math.min(((List)localObject3).size(), ((avom)localObject1).a());
            i = 0;
            if (i < j) {
              if (avjb.b.containsKey(((List)localObject3).get(i)))
              {
                localObject4 = (avjc)avjb.b.get(((List)localObject3).get(i));
                if (!((avjc)localObject4).jdField_a_of_type_Boolean)
                {
                  ((avjc)localObject4).jdField_a_of_type_Boolean = true;
                  localObject6 = new JSONObject();
                }
              }
            }
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          for (;;)
          {
            Object localObject4;
            ((JSONObject)localObject6).put("project", avsv.a());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("get_src", "native");
            ((JSONObject)localObject6).put("obj_lct", ((avjc)localObject4).jdField_a_of_type_Int);
            if (!(((List)localObject3).get(i) instanceof avos)) {
              break label716;
            }
            localObject7 = (avos)((List)localObject3).get(i);
            if (!((avos)localObject7).c()) {
              break;
            }
            localObject1 = "1";
            ((avjc)localObject4).jdField_b_of_type_JavaLangString = ((avos)localObject7).e();
            localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            avsv.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((avjc)localObject4).jdField_a_of_type_Long + "").obj2(((avjc)localObject4).jdField_b_of_type_JavaLangString).ver1(((avjc)localObject4).jdField_a_of_type_JavaLangString).ver2(avsv.a(this.b)).ver3((String)localObject1).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
            ((avjc)localObject4).jdField_a_of_type_Boolean = true;
            avjb.b.put(((List)localObject3).get(i), localObject4);
            i += 1;
          }
          localJSONException2 = localJSONException2;
          QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException2);
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException1);
            continue;
            localObject2 = "0";
            continue;
            label716:
            localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            avsv.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localJSONException2.jdField_a_of_type_Long + "").obj2(localJSONException2.jdField_b_of_type_JavaLangString).ver1(localJSONException2.jdField_a_of_type_JavaLangString).ver2(avsv.a(this.b)).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
            localJSONException2.jdField_a_of_type_Boolean = true;
            avjb.b.put(((List)localObject3).get(i), localJSONException2);
          }
        }
      }
    }
    Object localObject5;
    if ((localavol instanceof avnk))
    {
      localObject2 = (avnk)localavol;
      if ((((avnk)localObject2).a() != null) && (((avnk)localObject2).a().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((avnk)localObject2).a().size()) {
            break label1809;
          }
          localObject3 = (avol)((avnk)localObject2).a().get(i);
          if (avjb.b.containsKey(localObject3))
          {
            localObject3 = (avjc)avjb.b.get(localObject3);
            if (!((avjc)localObject3).jdField_a_of_type_Boolean)
            {
              ((avjc)localObject3).jdField_a_of_type_Boolean = true;
              localObject5 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject5).put("project", avsv.a());
            ((JSONObject)localObject5).put("event_src", "client");
            ((JSONObject)localObject5).put("get_src", "web");
            ((JSONObject)localObject5).put("obj_lct", ((avjc)localObject3).jdField_a_of_type_Int);
            localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            avsv.a((QQAppInterface)localObject6, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((avjc)localObject3).jdField_a_of_type_Long + "").obj2(((avjc)localObject3).jdField_b_of_type_JavaLangString).ver1(((avjc)localObject3).jdField_a_of_type_JavaLangString).ver2(avsv.a(this.b)).ver7(((JSONObject)localObject5).toString()).session_id(((QQAppInterface)localObject6).getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
            i += 1;
          }
          catch (JSONException localJSONException4)
          {
            for (;;)
            {
              QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException4);
            }
          }
        }
      }
    }
    else if ((localavol instanceof avpd))
    {
      localObject2 = ((avpd)localavol).a;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1809;
          }
          localObject3 = (avpc)((Iterator)localObject2).next();
          if (avjb.b.containsKey(localObject3))
          {
            localObject5 = (avjc)avjb.b.get(localObject3);
            if (!((avjc)localObject5).jdField_a_of_type_Boolean)
            {
              ((avjc)localObject5).jdField_a_of_type_Boolean = true;
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("project", avsv.a());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("get_src", "web");
                localJSONObject.put("obj_lct", ((avjc)localObject5).jdField_a_of_type_Int);
                localJSONObject.put("extra_info", ((avpc)localObject3).jdField_b_of_type_JavaLangString);
                localJSONObject.put("tepl", ((avpc)localObject3).f);
                localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                avsv.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((avpc)localObject3).jdField_a_of_type_Long + "").obj2(((avpc)localObject3).j).ver1(((avjc)localObject5).jdField_a_of_type_JavaLangString).ver2(avsv.a(this.b)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
              }
              catch (JSONException localJSONException5)
              {
                for (;;)
                {
                  QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException5);
                }
              }
            }
          }
        }
      }
    }
    else
    {
      if (!(localavol instanceof avpg)) {
        break label2257;
      }
      if (avjb.b.containsKey(localavol))
      {
        localObject2 = (avjc)avjb.b.get(localavol);
        localObject3 = (avpg)localavol;
        if (!((avjc)localObject2).jdField_a_of_type_Boolean)
        {
          ((avjc)localObject2).jdField_a_of_type_Boolean = true;
          localObject5 = new StringBuilder();
          if ((((avpg)localObject3).a != null) && (((avpg)localObject3).a.size() > 0))
          {
            i = 0;
            if (i < ((avpg)localObject3).a.size())
            {
              if (i != ((avpg)localObject3).a.size() - 1) {
                ((StringBuilder)localObject5).append(((avot)((avpg)localObject3).a.get(i)).jdField_b_of_type_JavaLangString).append("::");
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuilder)localObject5).append(((avot)((avpg)localObject3).a.get(i)).jdField_b_of_type_JavaLangString);
              }
            }
          }
          avsv.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((avjc)localObject2).jdField_a_of_type_JavaLangString).ver2(avsv.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + avsv.jdField_b_of_type_JavaLangString + "}"));
        }
      }
    }
    label1809:
    if (avjb.jdField_a_of_type_JavaUtilHashMap.containsKey(localavol))
    {
      localObject2 = (avjc)avjb.jdField_a_of_type_JavaUtilHashMap.get(localavol);
      if (!((avjc)localObject2).jdField_a_of_type_Boolean)
      {
        if (avwf.a(((avjc)localObject2).jdField_a_of_type_Long))
        {
          if (!((avjc)localObject2).jdField_b_of_type_Boolean) {
            break label2874;
          }
          i = 2;
          label1863:
          avwf.a("all_result", "exp_object", i, 0, new String[] { ((avjc)localObject2).jdField_a_of_type_JavaLangString, ((avjc)localObject2).jdField_a_of_type_Long + "", ((avjc)localObject2).jdField_b_of_type_JavaLangString, ((avjc)localObject2).jdField_a_of_type_Int + "" });
          ((avjc)localObject2).jdField_a_of_type_Boolean = true;
          avjb.jdField_a_of_type_JavaUtilHashMap.put((avon)localavol, localObject2);
        }
        if ((localavol instanceof avpw))
        {
          localObject3 = (avpw)localavol;
          if ((((avpw)localObject3).jdField_a_of_type_Int == -3) || (((avpw)localObject3).jdField_a_of_type_Int == -4)) {
            if (!((avjc)localObject2).jdField_b_of_type_Boolean) {
              break label2880;
            }
          }
        }
      }
    }
    label2874:
    label2880:
    for (int i = 2;; i = 1)
    {
      for (;;)
      {
        avwf.a("all_result", "exp_net_search", i, 0, new String[] { ((avjc)localObject2).jdField_a_of_type_JavaLangString, ((avjc)localObject2).jdField_a_of_type_Long + "", ((avjc)localObject2).jdField_b_of_type_JavaLangString, ((avjc)localObject2).jdField_a_of_type_Int + "" });
        localObject2 = paramView;
        if (!a(paramView, localavol)) {
          localObject2 = null;
        }
        paramView = super.getView(paramInt, (View)localObject2, paramViewGroup);
        a(paramInt, paramView, localavol);
        boolean bool1 = false;
        if (paramInt == 0) {
          bool1 = true;
        }
        boolean bool2 = bool1;
        if (paramInt >= 1)
        {
          i = getItemViewType(paramInt);
          j = getItemViewType(paramInt - 1);
          if (i != 11)
          {
            bool2 = bool1;
            if (i != 10) {}
          }
          else if (j != 11)
          {
            bool2 = bool1;
            if (j != 10) {}
          }
          else
          {
            bool2 = true;
          }
          bool2 = a(paramView, localavol, paramInt, i, j, bool2);
        }
        if ((paramView != null) && (paramView.findViewById(2131299715) != null))
        {
          if (!bool2) {
            break label2886;
          }
          paramView.findViewById(2131299715).setVisibility(8);
        }
        return paramView;
        label2257:
        if (((!(localavol instanceof avow)) || ((localavol instanceof avpk))) && (((!(localavol instanceof avnl)) && ((!(localavol instanceof avpw)) || (((avpw)localavol).jdField_a_of_type_Int != -4))) || (!avjb.b.containsKey(localavol)))) {
          break;
        }
        localObject2 = (avjc)avjb.b.get(localavol);
        if ((localavol instanceof avph))
        {
          localObject3 = (avph)localavol;
          if (!((avjc)localObject2).jdField_a_of_type_Boolean)
          {
            ((avjc)localObject2).jdField_a_of_type_Boolean = true;
            localObject5 = new StringBuilder();
            if ((((avph)localObject3).a != null) && (((avph)localObject3).a.size() > 0))
            {
              i = 0;
              while (i < ((avph)localObject3).a.size())
              {
                ((StringBuilder)localObject5).append(((avps)((avph)localObject3).a.get(i)).jdField_a_of_type_JavaLangString).append("::");
                i += 1;
              }
              avsv.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1("1007").ver1(((avjc)localObject2).jdField_a_of_type_JavaLangString).ver2(avsv.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + avsv.jdField_b_of_type_JavaLangString + "}"));
            }
            avsv.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((avjc)localObject2).jdField_a_of_type_JavaLangString).ver2(avsv.a(this.b)).ver5("2").ver7("{experiment_id:" + avsv.jdField_b_of_type_JavaLangString + "}"));
          }
        }
        if (((avjc)localObject2).jdField_a_of_type_Boolean) {
          break;
        }
        ((avjc)localObject2).jdField_a_of_type_Boolean = true;
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", avsv.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("get_src", "web");
          ((JSONObject)localObject3).put("obj_lct", ((avjc)localObject2).jdField_a_of_type_Int);
          if ((localavol instanceof avow)) {
            ((JSONObject)localObject3).put("tepl", ((avow)localavol).f);
          }
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          avsv.a((QQAppInterface)localObject5, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((avjc)localObject2).jdField_a_of_type_Long + "").obj2(((avjc)localObject2).jdField_b_of_type_JavaLangString).ver1(((avjc)localObject2).jdField_a_of_type_JavaLangString).ver2(avsv.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException3);
          }
        }
      }
      i = 1;
      break label1863;
    }
    label2886:
    paramView.findViewById(2131299715).setVisibility(0);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 63;
  }
  
  public void notifyDataSetChanged()
  {
    int i1 = getCount();
    int n = 0;
    int j = 0;
    int k = 0;
    int i = 0;
    if (n < i1)
    {
      Object localObject = a(n);
      int m;
      if ((localObject instanceof avnu))
      {
        localObject = (avnu)localObject;
        k = i + 1;
        ((avnu)localObject).a(1, k);
        i = j;
        if (((avnu)localObject).b() == 2) {
          i = j + 1;
        }
        ((avnu)localObject).a(3, i);
        ((avnu)localObject).a(0, k, i);
        m = 0;
        j = k;
        k = i;
        i = m;
      }
      for (;;)
      {
        n += 1;
        m = j;
        j = k;
        k = i;
        i = m;
        break;
        if ((localObject instanceof avpv))
        {
          localObject = (avpv)localObject;
          k += 1;
          ((avpv)localObject).a(k, i, j);
          m = i;
          i = k;
          k = j;
          j = m;
        }
        else
        {
          m = k;
          if ((localObject instanceof avnl))
          {
            localObject = (avnl)localObject;
            m = k + 1;
            ((avnl)localObject).a(m, i, j);
          }
          k = m;
          m = i;
          i = k;
          k = j;
          j = m;
        }
      }
    }
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "onDecodeTaskCompleted, remainingTasks : " + paramInt1 + ", type : " + paramInt2 + ", uin : " + paramString + ", avatar : " + paramBitmap + ", mFaceDecoder.isPausing() : " + this.jdField_a_of_type_Azwg.a() + ", mScrollState : " + this.jdField_a_of_type_Int);
    }
    if ((!this.jdField_a_of_type_Azwg.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        avok localavok;
        avrh localavrh;
        avwu localavwu;
        if (((localView.getTag(2131313373) instanceof avok)) && ((localView.getTag(2131313375) instanceof avrh)) && ((localView.getTag(2131313378) instanceof avwu)))
        {
          localavok = (avok)localView.getTag(2131313373);
          localavrh = (avrh)localView.getTag(2131313375);
          localavwu = (avwu)localView.getTag(2131313378);
          if ((localavok.c() == paramInt2) && (paramString.equals(localavok.b()))) {
            localavrh.a(localavok, localavwu, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localavok = (avok)((ViewGroup)localView).getChildAt(i).getTag(2131313373);
            if ((localavok != null) && (localavok.c() == paramInt2) && (paramString.equals(localavok.b())))
            {
              localavrh = (avrh)((ViewGroup)localView).getChildAt(i).getTag(2131313375);
              localavwu = (avwu)((ViewGroup)localView).getChildAt(i).getTag(2131313378);
              if ((localavrh != null) && (localavwu != null)) {
                localavrh.a(localavok, localavwu, paramBitmap);
              }
            }
            i += 1;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Begh != null) {
      this.jdField_a_of_type_Begh.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_Avtp.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    int k;
    int i;
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.jdField_a_of_type_Azwg.a()) {
        this.jdField_a_of_type_Azwg.b();
      }
      k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      i = 0;
    }
    while (i < k)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        int j = 0;
        while (j < ((ViewGroup)localView).getChildCount())
        {
          avok localavok = (avok)((ViewGroup)localView).getChildAt(j).getTag(2131313373);
          avrh localavrh = (avrh)((ViewGroup)localView).getChildAt(j).getTag(2131313375);
          avwu localavwu = (avwu)((ViewGroup)localView).getChildAt(j).getTag(2131313378);
          if ((localavrh != null) && (localavok != null) && (paramAbsListView != null)) {
            localavrh.a(localavok, localavwu);
          }
          j += 1;
        }
      }
      i += 1;
      continue;
      this.jdField_a_of_type_Azwg.a();
      this.jdField_a_of_type_Azwg.c();
    }
    if (this.jdField_a_of_type_Begh != null) {
      this.jdField_a_of_type_Begh.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.jdField_a_of_type_Avtp.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkm
 * JD-Core Version:    0.7.0.1
 */