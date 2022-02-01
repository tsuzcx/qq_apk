import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class baup
  extends baum
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  protected int a;
  private bbdu jdField_a_of_type_Bbdu = new bbdu();
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  public int b = -1;
  
  public baup(ListView paramListView, FaceDecoder paramFaceDecoder, AbsListView.OnScrollListener paramOnScrollListener, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    paramFaceDecoder.setDecodeTaskCompletionListener(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
    this.b = paramInt;
  }
  
  private bbdm a(int paramInt)
  {
    bayr localbayr = a(paramInt);
    if (localbayr == null) {
      return null;
    }
    if (!(localbayr instanceof bbdm)) {
      return null;
    }
    return (bbdm)localbayr;
  }
  
  private void a(int paramInt, View paramView, bayr parambayr)
  {
    if ((paramView == null) || (parambayr == null)) {}
    for (;;)
    {
      return;
      if ((parambayr instanceof bazz))
      {
        paramView = (bbhc)paramView.getTag(2131380836);
        if ((paramView instanceof bbdo)) {}
        for (paramView = ((bbdo)paramView).a(); paramView != null; paramView = null)
        {
          this.jdField_a_of_type_Bbdu.a(paramInt, paramView);
          return;
        }
      }
    }
  }
  
  private boolean a(View paramView, bayr parambayr)
  {
    if ((paramView == null) || (parambayr == null)) {
      return false;
    }
    if ((parambayr instanceof bazz))
    {
      bbhc localbbhc = (bbhc)paramView.getTag(2131380836);
      paramView = null;
      if ((localbbhc instanceof bbdo)) {
        paramView = ((bbdo)localbbhc).a();
      }
      if (paramView == null) {
        return false;
      }
      if ((((bazz)parambayr).f() != paramView.c()) || (((bazz)parambayr).h() != paramView.b())) {
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
  
  private boolean a(View paramView, bayr parambayr, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      if (paramView == null) {
        break label203;
      }
      paramView = (bbhc)paramView.getTag(2131380836);
      if (!(paramView instanceof bbdo)) {
        break label71;
      }
      paramView = (bbdo)paramView;
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof bbdy)))
      {
        if (paramInt1 != 0) {
          break label76;
        }
        ((bbdy)paramView).a(false);
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
            if ((!(localObject instanceof baya)) || (((baya)localObject).jdField_a_of_type_Boolean)) {
              break label197;
            }
          }
        }
      }
      label167:
      label197:
      for (Object localObject = ((baya)localObject).a().a();; localObject = null)
      {
        if ((parambayr != null) && (localObject != null) && (((List)localObject).contains(parambayr))) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label167;
          }
          ((bbdy)paramView).a(false);
          break;
        }
        break;
        paramView = a(paramInt1 - 1);
        if ((!(paramView instanceof bbdk)) || (((bbdk)paramView).a() != 1)) {
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
    Object localObject;
    if ((a(paramInt) instanceof baxq))
    {
      localObject = (baxq)a(paramInt);
      if (localObject != null) {
        return ((baxq)localObject).b();
      }
    }
    else if ((a(paramInt) instanceof baxr))
    {
      localObject = (baxr)a(paramInt);
      if (localObject != null) {
        return ((baxr)localObject).d();
      }
    }
    return 0;
  }
  
  protected bbbn a(int paramInt)
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
      return new bbch(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 41: 
      return new bbbl(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 3: 
      return new bbcd(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, false);
    case 12: 
      return new bbcd(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, true);
    case 57: 
      return new bbbh();
    case 0: 
      return new bbci();
    case 49: 
      return new bbcb();
    case 15: 
      return new bbci();
    case 2: 
    case 8: 
      return new bbbw(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 9: 
      return new bbcf();
    case 14: 
      return new bbcf();
    case 10: 
      return new bkps();
    case 11: 
      return new asmh(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 13: 
      return new bbay(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 56: 
      return new bbbo(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 60: 
      return new bbbs(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 16: 
      return new bbch(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new bbau(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, a(paramInt), this);
    case 29: 
    case 30: 
    case 36: 
      return new bbbi();
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
      return new bbcm(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this);
    case 46: 
      return new bbbx(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    }
    return new bbby(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this);
  }
  
  protected bbhc a(int paramInt, ViewGroup paramViewGroup)
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
      return new bbiq(paramViewGroup, 2131562743);
    case 41: 
      return new bbgy(paramViewGroup);
    case 3: 
      return new bbim(paramViewGroup);
    case 12: 
      return new bbik(paramViewGroup);
    case 57: 
      return new bbgw(paramViewGroup);
    case 0: 
    case 15: 
      localObject1 = a(paramInt);
      if (!(localObject1 instanceof baya)) {
        break;
      }
    }
    for (boolean bool1 = ((baya)localObject1).a();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new bbio(paramViewGroup, bool2, bool1);
      return new bbiq(paramViewGroup, 2131559640);
      return new bbil(paramViewGroup);
      return new bbin(paramViewGroup, 2131562763, 2130845934, -1);
      return new bbin(paramViewGroup, 2131562763, 2130845934, 12);
      return new bbir(paramViewGroup, 2131559841);
      return new bbgt(paramViewGroup, 2131562747);
      return new bbhd(paramViewGroup, 2131562749);
      return new bbhf(paramViewGroup, 2131562750);
      return new bbgs(paramViewGroup, 2131562792);
      return new bbiq(paramViewGroup, 2131562744);
      return new bbiq(paramViewGroup, 2131562751);
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = bbdw.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (bayr)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof bazz))) {
        ((bazz)localObject1).c(((bbdm)localObject2).b());
      }
      if (localObject2 == null) {
        return new bbgw(paramViewGroup);
      }
      return ((bbdm)localObject2).a();
      return new bbij(paramViewGroup, a(paramInt));
      localObject1 = a(paramInt);
      if ((localObject1 instanceof bbac)) {
        return new bbii(paramViewGroup, ((bbac)localObject1).d());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject1 = a(paramInt);
      if ((localObject1 instanceof bazc))
      {
        localObject1 = (bazc)localObject1;
        switch (((bazc)localObject1).d())
        {
        case 5: 
        case 10: 
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((bazc)localObject1).e() + " which is not supported!!!");
        case 2: 
          return new bbhg(paramViewGroup, ((bazc)localObject1).e());
        case 3: 
          return new bbic(paramViewGroup, ((bazc)localObject1).e());
        case 4: 
          return new bbhh(paramViewGroup, ((bazc)localObject1).e());
        case 7: 
          return new bbho(paramViewGroup, ((bazc)localObject1).e());
        case 6: 
          return new bbib(paramViewGroup, ((bazc)localObject1).e());
        case 8: 
          return new bbhz(paramViewGroup, ((bazc)localObject1).e());
        case 9: 
          return new bbhy(paramViewGroup, ((bazc)localObject1).e());
        case 11: 
          return new bbhl(paramViewGroup, ((bazc)localObject1).e());
        case 12: 
          return new bbhj(paramViewGroup, ((bazc)localObject1).e());
        case 13: 
          return new bbhm(paramViewGroup, ((bazc)localObject1).e());
        case 14: 
          return new bbia(paramViewGroup, ((bazc)localObject1).e());
        case 15: 
          return new bbhw(paramViewGroup, ((bazc)localObject1).e());
        case 16: 
          return new bbhr(paramViewGroup, ((bazc)localObject1).e());
        case 17: 
          return new bbht(paramViewGroup, ((bazc)localObject1).e());
        }
        return new bbhq(paramViewGroup, ((bazc)localObject1).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new bbir(paramViewGroup, 2131559641);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 12;
    if ((super.a(paramInt) instanceof bayc)) {
      i = 41;
    }
    do
    {
      return i;
      if ((super.a(paramInt) instanceof bayg)) {
        return 3;
      }
    } while ((super.a(paramInt) instanceof bawl));
    Object localObject;
    if (((super.a(paramInt) instanceof baya)) && (this.b != 12))
    {
      localObject = (baya)super.a(paramInt);
      if ((localObject != null) && (((baya)localObject).jdField_a_of_type_Boolean)) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof baya)) && (this.b == 12))
    {
      localObject = (baya)super.a(paramInt);
      if ((localObject != null) && (((baya)localObject).jdField_a_of_type_Boolean)) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof bayb))
    {
      localObject = (bayb)super.a(paramInt);
      if ((localObject != null) && (((bayb)localObject).jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof bayl)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof baxu)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof bayh)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof baxy)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof bayj)) {
      return 60;
    }
    if ((super.a(paramInt) instanceof baxw)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof baxs)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof bayi)) && (this.b != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof bayi)) && (this.b == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof bkpw)) {
      return 10;
    }
    if ((a(paramInt) instanceof asmk)) {
      return 11;
    }
    if (((super.a(paramInt) instanceof bayd)) || ((super.a(paramInt) instanceof bayf))) {
      return 13;
    }
    if ((a(paramInt) instanceof bayk)) {
      return 17;
    }
    if ((a(paramInt) instanceof baye)) {
      return 19;
    }
    if ((a(paramInt) instanceof bazz)) {
      return 59;
    }
    if ((a(paramInt) instanceof baxr))
    {
      localObject = (baxr)a(paramInt);
      if (localObject == null) {
        return 25;
      }
      switch (((baxr)localObject).d())
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
    if ((a(paramInt) instanceof bbac))
    {
      localObject = (bbac)a(paramInt);
      if (localObject == null) {
        return 29;
      }
      switch (((bbac)localObject).jdField_a_of_type_Int)
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
    if ((a(paramInt) instanceof bazc))
    {
      localObject = (bazc)a(paramInt);
      if (localObject == null) {
        return 45;
      }
      switch (((bazc)localObject).d())
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
    if ((a(paramInt) instanceof bazx)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bayr localbayr = a(paramInt);
    Object localObject3;
    int j;
    int i;
    Object localObject6;
    Object localObject7;
    if (batb.a(localbayr) > 0)
    {
      Object localObject1;
      if (batb.b.containsKey(localbayr))
      {
        localObject1 = (batc)batb.b.get(localbayr);
        if (!((batc)localObject1).jdField_a_of_type_Boolean)
        {
          ((batc)localObject1).jdField_a_of_type_Boolean = true;
          localObject3 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject3).put("project", bbda.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("get_src", "native");
        ((JSONObject)localObject3).put("obj_lct", ((batc)localObject1).jdField_a_of_type_Int);
        localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        bbda.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((batc)localObject1).jdField_a_of_type_Long + "").obj2(((batc)localObject1).jdField_b_of_type_JavaLangString).ver1(((batc)localObject1).jdField_a_of_type_JavaLangString).ver2(bbda.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + batb.jdField_a_of_type_Long));
        ((batc)localObject1).jdField_a_of_type_Boolean = true;
        batb.b.put(localbayr, localObject1);
        if ((localbayr instanceof bays))
        {
          localObject1 = (bays)localbayr;
          localObject3 = ((bays)localObject1).a();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            j = Math.min(((List)localObject3).size(), ((bays)localObject1).a());
            i = 0;
            if (i < j) {
              if (batb.b.containsKey(((List)localObject3).get(i)))
              {
                localObject4 = (batc)batb.b.get(((List)localObject3).get(i));
                if (!((batc)localObject4).jdField_a_of_type_Boolean)
                {
                  ((batc)localObject4).jdField_a_of_type_Boolean = true;
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
            ((JSONObject)localObject6).put("project", bbda.a());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("get_src", "native");
            ((JSONObject)localObject6).put("obj_lct", ((batc)localObject4).jdField_a_of_type_Int);
            if (!(((List)localObject3).get(i) instanceof bayy)) {
              break label716;
            }
            localObject7 = (bayy)((List)localObject3).get(i);
            if (!((bayy)localObject7).c()) {
              break;
            }
            localObject1 = "1";
            ((batc)localObject4).jdField_b_of_type_JavaLangString = ((bayy)localObject7).e();
            localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            bbda.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((batc)localObject4).jdField_a_of_type_Long + "").obj2(((batc)localObject4).jdField_b_of_type_JavaLangString).ver1(((batc)localObject4).jdField_a_of_type_JavaLangString).ver2(bbda.a(this.b)).ver3((String)localObject1).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + batb.jdField_a_of_type_Long));
            ((batc)localObject4).jdField_a_of_type_Boolean = true;
            batb.b.put(((List)localObject3).get(i), localObject4);
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
            bbda.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localJSONException2.jdField_a_of_type_Long + "").obj2(localJSONException2.jdField_b_of_type_JavaLangString).ver1(localJSONException2.jdField_a_of_type_JavaLangString).ver2(bbda.a(this.b)).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + batb.jdField_a_of_type_Long));
            localJSONException2.jdField_a_of_type_Boolean = true;
            batb.b.put(((List)localObject3).get(i), localJSONException2);
          }
        }
      }
    }
    Object localObject5;
    if ((localbayr instanceof baxq))
    {
      localObject2 = (baxq)localbayr;
      if ((((baxq)localObject2).a() != null) && (((baxq)localObject2).a().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((baxq)localObject2).a().size()) {
            break label1809;
          }
          localObject3 = (bayr)((baxq)localObject2).a().get(i);
          if (batb.b.containsKey(localObject3))
          {
            localObject3 = (batc)batb.b.get(localObject3);
            if (!((batc)localObject3).jdField_a_of_type_Boolean)
            {
              ((batc)localObject3).jdField_a_of_type_Boolean = true;
              localObject5 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject5).put("project", bbda.a());
            ((JSONObject)localObject5).put("event_src", "client");
            ((JSONObject)localObject5).put("get_src", "web");
            ((JSONObject)localObject5).put("obj_lct", ((batc)localObject3).jdField_a_of_type_Int);
            localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            bbda.a((QQAppInterface)localObject6, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((batc)localObject3).jdField_a_of_type_Long + "").obj2(((batc)localObject3).jdField_b_of_type_JavaLangString).ver1(((batc)localObject3).jdField_a_of_type_JavaLangString).ver2(bbda.a(this.b)).ver7(((JSONObject)localObject5).toString()).session_id(((QQAppInterface)localObject6).getCurrentAccountUin() + batb.jdField_a_of_type_Long));
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
    else if ((localbayr instanceof bazj))
    {
      localObject2 = ((bazj)localbayr).a;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1809;
          }
          localObject3 = (bazi)((Iterator)localObject2).next();
          if (batb.b.containsKey(localObject3))
          {
            localObject5 = (batc)batb.b.get(localObject3);
            if (!((batc)localObject5).jdField_a_of_type_Boolean)
            {
              ((batc)localObject5).jdField_a_of_type_Boolean = true;
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("project", bbda.a());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("get_src", "web");
                localJSONObject.put("obj_lct", ((batc)localObject5).jdField_a_of_type_Int);
                localJSONObject.put("extra_info", ((bazi)localObject3).jdField_b_of_type_JavaLangString);
                localJSONObject.put("tepl", ((bazi)localObject3).f);
                localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                bbda.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bazi)localObject3).jdField_a_of_type_Long + "").obj2(((bazi)localObject3).j).ver1(((batc)localObject5).jdField_a_of_type_JavaLangString).ver2(bbda.a(this.b)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + batb.jdField_a_of_type_Long));
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
      if (!(localbayr instanceof bazm)) {
        break label2272;
      }
      if (batb.b.containsKey(localbayr))
      {
        localObject2 = (batc)batb.b.get(localbayr);
        localObject3 = (bazm)localbayr;
        if (!((batc)localObject2).jdField_a_of_type_Boolean)
        {
          ((batc)localObject2).jdField_a_of_type_Boolean = true;
          localObject5 = new StringBuilder();
          if ((((bazm)localObject3).a != null) && (((bazm)localObject3).a.size() > 0))
          {
            i = 0;
            if (i < ((bazm)localObject3).a.size())
            {
              if (i != ((bazm)localObject3).a.size() - 1) {
                ((StringBuilder)localObject5).append(((bayz)((bazm)localObject3).a.get(i)).jdField_b_of_type_JavaLangString).append("::");
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuilder)localObject5).append(((bayz)((bazm)localObject3).a.get(i)).jdField_b_of_type_JavaLangString);
              }
            }
          }
          bbda.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((batc)localObject2).jdField_a_of_type_JavaLangString).ver2(bbda.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + bbda.jdField_b_of_type_JavaLangString + "}"));
        }
      }
    }
    label1809:
    if (batb.jdField_a_of_type_JavaUtilHashMap.containsKey(localbayr))
    {
      localObject2 = (batc)batb.jdField_a_of_type_JavaUtilHashMap.get(localbayr);
      if (!((batc)localObject2).jdField_a_of_type_Boolean)
      {
        if (bbgk.a(((batc)localObject2).jdField_a_of_type_Long))
        {
          if (!((batc)localObject2).jdField_b_of_type_Boolean) {
            break label2889;
          }
          i = 2;
          label1863:
          bbgk.a("all_result", "exp_object", i, 0, new String[] { ((batc)localObject2).jdField_a_of_type_JavaLangString, ((batc)localObject2).jdField_a_of_type_Long + "", ((batc)localObject2).jdField_b_of_type_JavaLangString, ((batc)localObject2).jdField_a_of_type_Int + "" });
          ((batc)localObject2).jdField_a_of_type_Boolean = true;
          batb.jdField_a_of_type_JavaUtilHashMap.put((bayt)localbayr, localObject2);
        }
        if ((localbayr instanceof bbac))
        {
          localObject3 = (bbac)localbayr;
          if ((((bbac)localObject3).jdField_a_of_type_Int == -3) || (((bbac)localObject3).jdField_a_of_type_Int == -4))
          {
            if (!((batc)localObject2).jdField_b_of_type_Boolean) {
              break label2895;
            }
            i = 2;
            label2015:
            bbgk.a("all_result", "exp_net_search", i, 0, new String[] { ((batc)localObject2).jdField_a_of_type_JavaLangString, ((batc)localObject2).jdField_a_of_type_Long + "", ((batc)localObject2).jdField_b_of_type_JavaLangString, ((batc)localObject2).jdField_a_of_type_Int + "" });
          }
        }
      }
    }
    Object localObject2 = paramView;
    if (!a(paramView, localbayr)) {
      localObject2 = null;
    }
    paramView = super.getView(paramInt, (View)localObject2, paramViewGroup);
    a(paramInt, paramView, localbayr);
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
      bool2 = a(paramView, localbayr, paramInt, i, j, bool2);
    }
    if ((paramView != null) && (paramView.findViewById(2131365682) != null))
    {
      if (!bool2) {
        break label2901;
      }
      paramView.findViewById(2131365682).setVisibility(8);
    }
    for (;;)
    {
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
        return paramView;
        label2272:
        if (((!(localbayr instanceof bazc)) || ((localbayr instanceof bazq))) && (((!(localbayr instanceof baxr)) && ((!(localbayr instanceof bbac)) || (((bbac)localbayr).jdField_a_of_type_Int != -4))) || (!batb.b.containsKey(localbayr)))) {
          break;
        }
        localObject2 = (batc)batb.b.get(localbayr);
        if ((localbayr instanceof bazn))
        {
          localObject3 = (bazn)localbayr;
          if (!((batc)localObject2).jdField_a_of_type_Boolean)
          {
            ((batc)localObject2).jdField_a_of_type_Boolean = true;
            localObject5 = new StringBuilder();
            if ((((bazn)localObject3).a != null) && (((bazn)localObject3).a.size() > 0))
            {
              i = 0;
              while (i < ((bazn)localObject3).a.size())
              {
                ((StringBuilder)localObject5).append(((bazy)((bazn)localObject3).a.get(i)).jdField_a_of_type_JavaLangString).append("::");
                i += 1;
              }
              bbda.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1("1007").ver1(((batc)localObject2).jdField_a_of_type_JavaLangString).ver2(bbda.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + bbda.jdField_b_of_type_JavaLangString + "}"));
            }
            bbda.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((batc)localObject2).jdField_a_of_type_JavaLangString).ver2(bbda.a(this.b)).ver5("2").ver7("{experiment_id:" + bbda.jdField_b_of_type_JavaLangString + "}"));
          }
        }
        if (((batc)localObject2).jdField_a_of_type_Boolean) {
          break;
        }
        ((batc)localObject2).jdField_a_of_type_Boolean = true;
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", bbda.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("get_src", "web");
          ((JSONObject)localObject3).put("obj_lct", ((batc)localObject2).jdField_a_of_type_Int);
          if ((localbayr instanceof bazc)) {
            ((JSONObject)localObject3).put("tepl", ((bazc)localbayr).f);
          }
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bbda.a((QQAppInterface)localObject5, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((batc)localObject2).jdField_a_of_type_Long + "").obj2(((batc)localObject2).jdField_b_of_type_JavaLangString).ver1(((batc)localObject2).jdField_a_of_type_JavaLangString).ver2(bbda.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + batb.jdField_a_of_type_Long));
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException3);
          }
        }
      }
      label2889:
      i = 1;
      break label1863;
      label2895:
      i = 1;
      break label2015;
      label2901:
      paramView.findViewById(2131365682).setVisibility(0);
    }
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
      if ((localObject instanceof baya))
      {
        localObject = (baya)localObject;
        k = i + 1;
        ((baya)localObject).a(1, k);
        i = j;
        if (((baya)localObject).b() == 2) {
          i = j + 1;
        }
        ((baya)localObject).a(3, i);
        ((baya)localObject).a(0, k, i);
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
        if ((localObject instanceof bbab))
        {
          localObject = (bbab)localObject;
          k += 1;
          ((bbab)localObject).a(k, i, j);
          m = i;
          i = k;
          k = j;
          j = m;
        }
        else
        {
          m = k;
          if ((localObject instanceof baxr))
          {
            localObject = (baxr)localObject;
            m = k + 1;
            ((baxr)localObject).a(m, i, j);
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
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "onDecodeTaskCompleted, remainingTasks : " + paramInt1 + ", type : " + paramInt2 + ", uin : " + paramString + ", avatar : " + paramBitmap + ", mFaceDecoder.isPausing() : " + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing() + ", mScrollState : " + this.jdField_a_of_type_Int);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        bayq localbayq;
        bbbm localbbbm;
        bbgz localbbgz;
        if (((localView.getTag(2131380831) instanceof bayq)) && ((localView.getTag(2131380833) instanceof bbbm)) && ((localView.getTag(2131380836) instanceof bbgz)))
        {
          localbayq = (bayq)localView.getTag(2131380831);
          localbbbm = (bbbm)localView.getTag(2131380833);
          localbbgz = (bbgz)localView.getTag(2131380836);
          if ((localbayq.c() == paramInt2) && (paramString.equals(localbayq.b()))) {
            localbbbm.a(localbayq, localbbgz, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localbayq = (bayq)((ViewGroup)localView).getChildAt(i).getTag(2131380831);
            if ((localbayq != null) && (localbayq.c() == paramInt2) && (paramString.equals(localbayq.b())))
            {
              localbbbm = (bbbm)((ViewGroup)localView).getChildAt(i).getTag(2131380833);
              localbbgz = (bbgz)((ViewGroup)localView).getChildAt(i).getTag(2131380836);
              if ((localbbbm != null) && (localbbgz != null)) {
                localbbbm.a(localbayq, localbbgz, paramBitmap);
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
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_Bbdu.a(paramInt1, paramInt2, paramInt3);
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
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
          bayq localbayq = (bayq)((ViewGroup)localView).getChildAt(j).getTag(2131380831);
          bbbm localbbbm = (bbbm)((ViewGroup)localView).getChildAt(j).getTag(2131380833);
          bbgz localbbgz = (bbgz)((ViewGroup)localView).getChildAt(j).getTag(2131380836);
          if ((localbbbm != null) && (localbayq != null) && (paramAbsListView != null)) {
            localbbbm.a(localbayq, localbbgz);
          }
          j += 1;
        }
      }
      i += 1;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.jdField_a_of_type_Bbdu.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baup
 * JD-Core Version:    0.7.0.1
 */