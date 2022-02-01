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

public class bcbf
  extends bcbc
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  protected int a;
  private bckm jdField_a_of_type_Bckm = new bckm();
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  public int b = -1;
  
  public bcbf(ListView paramListView, FaceDecoder paramFaceDecoder, AbsListView.OnScrollListener paramOnScrollListener, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    paramFaceDecoder.setDecodeTaskCompletionListener(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
    this.b = paramInt;
  }
  
  private bcke a(int paramInt)
  {
    bcfh localbcfh = a(paramInt);
    if (localbcfh == null) {
      return null;
    }
    if (!(localbcfh instanceof bcke)) {
      return null;
    }
    return (bcke)localbcfh;
  }
  
  private void a(int paramInt, View paramView, bcfh parambcfh)
  {
    if ((paramView == null) || (parambcfh == null)) {}
    for (;;)
    {
      return;
      if ((parambcfh instanceof bcgp))
      {
        paramView = (bcnu)paramView.getTag(2131381188);
        if ((paramView instanceof bckg)) {}
        for (paramView = ((bckg)paramView).a(); paramView != null; paramView = null)
        {
          this.jdField_a_of_type_Bckm.a(paramInt, paramView);
          return;
        }
      }
    }
  }
  
  private boolean a(View paramView, bcfh parambcfh)
  {
    if ((paramView == null) || (parambcfh == null)) {
      return false;
    }
    if ((parambcfh instanceof bcgp))
    {
      bcnu localbcnu = (bcnu)paramView.getTag(2131381188);
      paramView = null;
      if ((localbcnu instanceof bckg)) {
        paramView = ((bckg)localbcnu).a();
      }
      if (paramView == null) {
        return false;
      }
      if ((((bcgp)parambcfh).f() != paramView.c()) || (((bcgp)parambcfh).h() != paramView.b())) {
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
  
  private boolean a(View paramView, bcfh parambcfh, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      if (paramView == null) {
        break label203;
      }
      paramView = (bcnu)paramView.getTag(2131381188);
      if (!(paramView instanceof bckg)) {
        break label71;
      }
      paramView = (bckg)paramView;
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof bckq)))
      {
        if (paramInt1 != 0) {
          break label76;
        }
        ((bckq)paramView).a(false);
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
            if ((!(localObject instanceof bceq)) || (((bceq)localObject).jdField_a_of_type_Boolean)) {
              break label197;
            }
          }
        }
      }
      label167:
      label197:
      for (Object localObject = ((bceq)localObject).a().a();; localObject = null)
      {
        if ((parambcfh != null) && (localObject != null) && (((List)localObject).contains(parambcfh))) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label167;
          }
          ((bckq)paramView).a(false);
          break;
        }
        break;
        paramView = a(paramInt1 - 1);
        if ((!(paramView instanceof bckc)) || (((bckc)paramView).a() != 1)) {
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
    if ((a(paramInt) instanceof bceg))
    {
      localObject = (bceg)a(paramInt);
      if (localObject != null) {
        return ((bceg)localObject).b();
      }
    }
    else if ((a(paramInt) instanceof bceh))
    {
      localObject = (bceh)a(paramInt);
      if (localObject != null) {
        return ((bceh)localObject).d();
      }
    }
    return 0;
  }
  
  protected bcif a(int paramInt)
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
      return new bciz(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 41: 
      return new bcid(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 3: 
      return new bciv(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, false);
    case 12: 
      return new bciv(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, true);
    case 57: 
      return new bchz();
    case 0: 
      return new bcja();
    case 49: 
      return new bcit();
    case 15: 
      return new bcja();
    case 2: 
    case 8: 
      return new bcio(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 9: 
      return new bcix();
    case 14: 
      return new bcix();
    case 10: 
      return new bmba();
    case 11: 
      return new atqn(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 13: 
      return new bchq(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 56: 
      return new bcig(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 60: 
      return new bcik(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 16: 
      return new bciz(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new bchk(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, a(paramInt), this);
    case 29: 
    case 30: 
    case 36: 
      return new bcia();
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
      return new bcje(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this);
    case 46: 
      return new bcip(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    }
    return new bciq(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this);
  }
  
  protected bcnu a(int paramInt, ViewGroup paramViewGroup)
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
      return new bcpi(paramViewGroup, 2131562814);
    case 41: 
      return new bcnq(paramViewGroup);
    case 3: 
      return new bcpe(paramViewGroup);
    case 12: 
      return new bcpc(paramViewGroup);
    case 57: 
      return new bcno(paramViewGroup);
    case 0: 
    case 15: 
      localObject1 = a(paramInt);
      if (!(localObject1 instanceof bceq)) {
        break;
      }
    }
    for (boolean bool1 = ((bceq)localObject1).a();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new bcpg(paramViewGroup, bool2, bool1);
      return new bcpi(paramViewGroup, 2131559675);
      return new bcpd(paramViewGroup);
      return new bcpf(paramViewGroup, 2131562834, 2130846022, -1);
      return new bcpf(paramViewGroup, 2131562834, 2130846022, 12);
      return new bcpj(paramViewGroup, 2131559885);
      return new bcnl(paramViewGroup, 2131562818);
      return new bcnv(paramViewGroup, 2131562820);
      return new bcnx(paramViewGroup, 2131562821);
      return new bcnk(paramViewGroup, 2131562863);
      return new bcpi(paramViewGroup, 2131562815);
      return new bcpi(paramViewGroup, 2131562822);
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = bcko.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (bcfh)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof bcgp))) {
        ((bcgp)localObject1).c(((bcke)localObject2).b());
      }
      if (localObject2 == null) {
        return new bcno(paramViewGroup);
      }
      return ((bcke)localObject2).a();
      return new bcpb(paramViewGroup, a(paramInt));
      localObject1 = a(paramInt);
      if ((localObject1 instanceof bcgs)) {
        return new bcpa(paramViewGroup, ((bcgs)localObject1).d());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject1 = a(paramInt);
      if ((localObject1 instanceof bcfs))
      {
        localObject1 = (bcfs)localObject1;
        switch (((bcfs)localObject1).d())
        {
        case 5: 
        case 10: 
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((bcfs)localObject1).e() + " which is not supported!!!");
        case 2: 
          return new bcny(paramViewGroup, ((bcfs)localObject1).e());
        case 3: 
          return new bcou(paramViewGroup, ((bcfs)localObject1).e());
        case 4: 
          return new bcnz(paramViewGroup, ((bcfs)localObject1).e());
        case 7: 
          return new bcog(paramViewGroup, ((bcfs)localObject1).e());
        case 6: 
          return new bcot(paramViewGroup, ((bcfs)localObject1).e());
        case 8: 
          return new bcor(paramViewGroup, ((bcfs)localObject1).e());
        case 9: 
          return new bcoq(paramViewGroup, ((bcfs)localObject1).e());
        case 11: 
          return new bcod(paramViewGroup, ((bcfs)localObject1).e());
        case 12: 
          return new bcob(paramViewGroup, ((bcfs)localObject1).e());
        case 13: 
          return new bcoe(paramViewGroup, ((bcfs)localObject1).e());
        case 14: 
          return new bcos(paramViewGroup, ((bcfs)localObject1).e());
        case 15: 
          return new bcoo(paramViewGroup, ((bcfs)localObject1).e());
        case 16: 
          return new bcoj(paramViewGroup, ((bcfs)localObject1).e());
        case 17: 
          return new bcol(paramViewGroup, ((bcfs)localObject1).e());
        }
        return new bcoi(paramViewGroup, ((bcfs)localObject1).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new bcpj(paramViewGroup, 2131559676);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 12;
    if ((super.a(paramInt) instanceof bces)) {
      i = 41;
    }
    do
    {
      return i;
      if ((super.a(paramInt) instanceof bcew)) {
        return 3;
      }
    } while ((super.a(paramInt) instanceof bcdb));
    Object localObject;
    if (((super.a(paramInt) instanceof bceq)) && (this.b != 12))
    {
      localObject = (bceq)super.a(paramInt);
      if ((localObject != null) && (((bceq)localObject).jdField_a_of_type_Boolean)) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof bceq)) && (this.b == 12))
    {
      localObject = (bceq)super.a(paramInt);
      if ((localObject != null) && (((bceq)localObject).jdField_a_of_type_Boolean)) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof bcer))
    {
      localObject = (bcer)super.a(paramInt);
      if ((localObject != null) && (((bcer)localObject).jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof bcfb)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof bcek)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof bcex)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof bceo)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof bcez)) {
      return 60;
    }
    if ((super.a(paramInt) instanceof bcem)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof bcei)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof bcey)) && (this.b != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof bcey)) && (this.b == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof bmbe)) {
      return 10;
    }
    if ((a(paramInt) instanceof atqq)) {
      return 11;
    }
    if (((super.a(paramInt) instanceof bcet)) || ((super.a(paramInt) instanceof bcev))) {
      return 13;
    }
    if ((a(paramInt) instanceof bcfa)) {
      return 17;
    }
    if ((a(paramInt) instanceof bceu)) {
      return 19;
    }
    if ((a(paramInt) instanceof bcgp)) {
      return 59;
    }
    if ((a(paramInt) instanceof bceh))
    {
      localObject = (bceh)a(paramInt);
      if (localObject == null) {
        return 25;
      }
      switch (((bceh)localObject).d())
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
    if ((a(paramInt) instanceof bcgs))
    {
      localObject = (bcgs)a(paramInt);
      if (localObject == null) {
        return 29;
      }
      switch (((bcgs)localObject).jdField_a_of_type_Int)
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
    if ((a(paramInt) instanceof bcfs))
    {
      localObject = (bcfs)a(paramInt);
      if (localObject == null) {
        return 45;
      }
      switch (((bcfs)localObject).d())
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
    if ((a(paramInt) instanceof bcgn)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bcfh localbcfh = a(paramInt);
    Object localObject3;
    int j;
    int i;
    Object localObject6;
    Object localObject7;
    if (bbzq.a(localbcfh) > 0)
    {
      Object localObject1;
      if (bbzq.b.containsKey(localbcfh))
      {
        localObject1 = (bbzr)bbzq.b.get(localbcfh);
        if (!((bbzr)localObject1).jdField_a_of_type_Boolean)
        {
          ((bbzr)localObject1).jdField_a_of_type_Boolean = true;
          localObject3 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject3).put("project", bcjs.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("get_src", "native");
        ((JSONObject)localObject3).put("obj_lct", ((bbzr)localObject1).jdField_a_of_type_Int);
        localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        bcjs.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbzr)localObject1).jdField_a_of_type_Long + "").obj2(((bbzr)localObject1).jdField_b_of_type_JavaLangString).ver1(((bbzr)localObject1).jdField_a_of_type_JavaLangString).ver2(bcjs.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
        ((bbzr)localObject1).jdField_a_of_type_Boolean = true;
        bbzq.b.put(localbcfh, localObject1);
        if ((localbcfh instanceof bcfi))
        {
          localObject1 = (bcfi)localbcfh;
          localObject3 = ((bcfi)localObject1).a();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            j = Math.min(((List)localObject3).size(), ((bcfi)localObject1).a());
            i = 0;
            if (i < j) {
              if (bbzq.b.containsKey(((List)localObject3).get(i)))
              {
                localObject4 = (bbzr)bbzq.b.get(((List)localObject3).get(i));
                if (!((bbzr)localObject4).jdField_a_of_type_Boolean)
                {
                  ((bbzr)localObject4).jdField_a_of_type_Boolean = true;
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
            ((JSONObject)localObject6).put("project", bcjs.a());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("get_src", "native");
            ((JSONObject)localObject6).put("obj_lct", ((bbzr)localObject4).jdField_a_of_type_Int);
            if (!(((List)localObject3).get(i) instanceof bcfo)) {
              break label716;
            }
            localObject7 = (bcfo)((List)localObject3).get(i);
            if (!((bcfo)localObject7).c()) {
              break;
            }
            localObject1 = "1";
            ((bbzr)localObject4).jdField_b_of_type_JavaLangString = ((bcfo)localObject7).e();
            localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            bcjs.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbzr)localObject4).jdField_a_of_type_Long + "").obj2(((bbzr)localObject4).jdField_b_of_type_JavaLangString).ver1(((bbzr)localObject4).jdField_a_of_type_JavaLangString).ver2(bcjs.a(this.b)).ver3((String)localObject1).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
            ((bbzr)localObject4).jdField_a_of_type_Boolean = true;
            bbzq.b.put(((List)localObject3).get(i), localObject4);
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
            bcjs.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localJSONException2.jdField_a_of_type_Long + "").obj2(localJSONException2.jdField_b_of_type_JavaLangString).ver1(localJSONException2.jdField_a_of_type_JavaLangString).ver2(bcjs.a(this.b)).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
            localJSONException2.jdField_a_of_type_Boolean = true;
            bbzq.b.put(((List)localObject3).get(i), localJSONException2);
          }
        }
      }
    }
    Object localObject5;
    if ((localbcfh instanceof bceg))
    {
      localObject2 = (bceg)localbcfh;
      if ((((bceg)localObject2).a() != null) && (((bceg)localObject2).a().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((bceg)localObject2).a().size()) {
            break label1809;
          }
          localObject3 = (bcfh)((bceg)localObject2).a().get(i);
          if (bbzq.b.containsKey(localObject3))
          {
            localObject3 = (bbzr)bbzq.b.get(localObject3);
            if (!((bbzr)localObject3).jdField_a_of_type_Boolean)
            {
              ((bbzr)localObject3).jdField_a_of_type_Boolean = true;
              localObject5 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject5).put("project", bcjs.a());
            ((JSONObject)localObject5).put("event_src", "client");
            ((JSONObject)localObject5).put("get_src", "web");
            ((JSONObject)localObject5).put("obj_lct", ((bbzr)localObject3).jdField_a_of_type_Int);
            localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            bcjs.a((QQAppInterface)localObject6, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbzr)localObject3).jdField_a_of_type_Long + "").obj2(((bbzr)localObject3).jdField_b_of_type_JavaLangString).ver1(((bbzr)localObject3).jdField_a_of_type_JavaLangString).ver2(bcjs.a(this.b)).ver7(((JSONObject)localObject5).toString()).session_id(((QQAppInterface)localObject6).getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
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
    else if ((localbcfh instanceof bcfz))
    {
      localObject2 = ((bcfz)localbcfh).a;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1809;
          }
          localObject3 = (bcfy)((Iterator)localObject2).next();
          if (bbzq.b.containsKey(localObject3))
          {
            localObject5 = (bbzr)bbzq.b.get(localObject3);
            if (!((bbzr)localObject5).jdField_a_of_type_Boolean)
            {
              ((bbzr)localObject5).jdField_a_of_type_Boolean = true;
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("project", bcjs.a());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("get_src", "web");
                localJSONObject.put("obj_lct", ((bbzr)localObject5).jdField_a_of_type_Int);
                localJSONObject.put("extra_info", ((bcfy)localObject3).jdField_b_of_type_JavaLangString);
                localJSONObject.put("tepl", ((bcfy)localObject3).f);
                localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                bcjs.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bcfy)localObject3).jdField_a_of_type_Long + "").obj2(((bcfy)localObject3).j).ver1(((bbzr)localObject5).jdField_a_of_type_JavaLangString).ver2(bcjs.a(this.b)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
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
      if (!(localbcfh instanceof bcgc)) {
        break label2272;
      }
      if (bbzq.b.containsKey(localbcfh))
      {
        localObject2 = (bbzr)bbzq.b.get(localbcfh);
        localObject3 = (bcgc)localbcfh;
        if (!((bbzr)localObject2).jdField_a_of_type_Boolean)
        {
          ((bbzr)localObject2).jdField_a_of_type_Boolean = true;
          localObject5 = new StringBuilder();
          if ((((bcgc)localObject3).a != null) && (((bcgc)localObject3).a.size() > 0))
          {
            i = 0;
            if (i < ((bcgc)localObject3).a.size())
            {
              if (i != ((bcgc)localObject3).a.size() - 1) {
                ((StringBuilder)localObject5).append(((bcfp)((bcgc)localObject3).a.get(i)).jdField_b_of_type_JavaLangString).append("::");
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuilder)localObject5).append(((bcfp)((bcgc)localObject3).a.get(i)).jdField_b_of_type_JavaLangString);
              }
            }
          }
          bcjs.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((bbzr)localObject2).jdField_a_of_type_JavaLangString).ver2(bcjs.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + bcjs.jdField_b_of_type_JavaLangString + "}"));
        }
      }
    }
    label1809:
    if (bbzq.jdField_a_of_type_JavaUtilHashMap.containsKey(localbcfh))
    {
      localObject2 = (bbzr)bbzq.jdField_a_of_type_JavaUtilHashMap.get(localbcfh);
      if (!((bbzr)localObject2).jdField_a_of_type_Boolean)
      {
        if (bcnc.a(((bbzr)localObject2).jdField_a_of_type_Long))
        {
          if (!((bbzr)localObject2).jdField_b_of_type_Boolean) {
            break label2889;
          }
          i = 2;
          label1863:
          bcnc.a("all_result", "exp_object", i, 0, new String[] { ((bbzr)localObject2).jdField_a_of_type_JavaLangString, ((bbzr)localObject2).jdField_a_of_type_Long + "", ((bbzr)localObject2).jdField_b_of_type_JavaLangString, ((bbzr)localObject2).jdField_a_of_type_Int + "" });
          ((bbzr)localObject2).jdField_a_of_type_Boolean = true;
          bbzq.jdField_a_of_type_JavaUtilHashMap.put((bcfj)localbcfh, localObject2);
        }
        if ((localbcfh instanceof bcgs))
        {
          localObject3 = (bcgs)localbcfh;
          if ((((bcgs)localObject3).jdField_a_of_type_Int == -3) || (((bcgs)localObject3).jdField_a_of_type_Int == -4))
          {
            if (!((bbzr)localObject2).jdField_b_of_type_Boolean) {
              break label2895;
            }
            i = 2;
            label2015:
            bcnc.a("all_result", "exp_net_search", i, 0, new String[] { ((bbzr)localObject2).jdField_a_of_type_JavaLangString, ((bbzr)localObject2).jdField_a_of_type_Long + "", ((bbzr)localObject2).jdField_b_of_type_JavaLangString, ((bbzr)localObject2).jdField_a_of_type_Int + "" });
          }
        }
      }
    }
    Object localObject2 = paramView;
    if (!a(paramView, localbcfh)) {
      localObject2 = null;
    }
    paramView = super.getView(paramInt, (View)localObject2, paramViewGroup);
    a(paramInt, paramView, localbcfh);
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
      bool2 = a(paramView, localbcfh, paramInt, i, j, bool2);
    }
    if ((paramView != null) && (paramView.findViewById(2131365776) != null))
    {
      if (!bool2) {
        break label2901;
      }
      paramView.findViewById(2131365776).setVisibility(8);
    }
    for (;;)
    {
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
        return paramView;
        label2272:
        if (((!(localbcfh instanceof bcfs)) || ((localbcfh instanceof bcgg))) && (((!(localbcfh instanceof bceh)) && ((!(localbcfh instanceof bcgs)) || (((bcgs)localbcfh).jdField_a_of_type_Int != -4))) || (!bbzq.b.containsKey(localbcfh)))) {
          break;
        }
        localObject2 = (bbzr)bbzq.b.get(localbcfh);
        if ((localbcfh instanceof bcgd))
        {
          localObject3 = (bcgd)localbcfh;
          if (!((bbzr)localObject2).jdField_a_of_type_Boolean)
          {
            ((bbzr)localObject2).jdField_a_of_type_Boolean = true;
            localObject5 = new StringBuilder();
            if ((((bcgd)localObject3).a != null) && (((bcgd)localObject3).a.size() > 0))
            {
              i = 0;
              while (i < ((bcgd)localObject3).a.size())
              {
                ((StringBuilder)localObject5).append(((bcgo)((bcgd)localObject3).a.get(i)).jdField_a_of_type_JavaLangString).append("::");
                i += 1;
              }
              bcjs.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1("1007").ver1(((bbzr)localObject2).jdField_a_of_type_JavaLangString).ver2(bcjs.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + bcjs.jdField_b_of_type_JavaLangString + "}"));
            }
            bcjs.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((bbzr)localObject2).jdField_a_of_type_JavaLangString).ver2(bcjs.a(this.b)).ver5("2").ver7("{experiment_id:" + bcjs.jdField_b_of_type_JavaLangString + "}"));
          }
        }
        if (((bbzr)localObject2).jdField_a_of_type_Boolean) {
          break;
        }
        ((bbzr)localObject2).jdField_a_of_type_Boolean = true;
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", bcjs.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("get_src", "web");
          ((JSONObject)localObject3).put("obj_lct", ((bbzr)localObject2).jdField_a_of_type_Int);
          if ((localbcfh instanceof bcfs)) {
            ((JSONObject)localObject3).put("tepl", ((bcfs)localbcfh).f);
          }
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bcjs.a((QQAppInterface)localObject5, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbzr)localObject2).jdField_a_of_type_Long + "").obj2(((bbzr)localObject2).jdField_b_of_type_JavaLangString).ver1(((bbzr)localObject2).jdField_a_of_type_JavaLangString).ver2(bcjs.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
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
      paramView.findViewById(2131365776).setVisibility(0);
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
      if ((localObject instanceof bceq))
      {
        localObject = (bceq)localObject;
        k = i + 1;
        ((bceq)localObject).a(1, k);
        i = j;
        if (((bceq)localObject).b() == 2) {
          i = j + 1;
        }
        ((bceq)localObject).a(3, i);
        ((bceq)localObject).a(0, k, i);
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
        if ((localObject instanceof bcgr))
        {
          localObject = (bcgr)localObject;
          k += 1;
          ((bcgr)localObject).a(k, i, j);
          m = i;
          i = k;
          k = j;
          j = m;
        }
        else
        {
          m = k;
          if ((localObject instanceof bceh))
          {
            localObject = (bceh)localObject;
            m = k + 1;
            ((bceh)localObject).a(m, i, j);
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
        bcfg localbcfg;
        bcie localbcie;
        bcnr localbcnr;
        if (((localView.getTag(2131381183) instanceof bcfg)) && ((localView.getTag(2131381185) instanceof bcie)) && ((localView.getTag(2131381188) instanceof bcnr)))
        {
          localbcfg = (bcfg)localView.getTag(2131381183);
          localbcie = (bcie)localView.getTag(2131381185);
          localbcnr = (bcnr)localView.getTag(2131381188);
          if ((localbcfg.c() == paramInt2) && (paramString.equals(localbcfg.b()))) {
            localbcie.a(localbcfg, localbcnr, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localbcfg = (bcfg)((ViewGroup)localView).getChildAt(i).getTag(2131381183);
            if ((localbcfg != null) && (localbcfg.c() == paramInt2) && (paramString.equals(localbcfg.b())))
            {
              localbcie = (bcie)((ViewGroup)localView).getChildAt(i).getTag(2131381185);
              localbcnr = (bcnr)((ViewGroup)localView).getChildAt(i).getTag(2131381188);
              if ((localbcie != null) && (localbcnr != null)) {
                localbcie.a(localbcfg, localbcnr, paramBitmap);
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
    this.jdField_a_of_type_Bckm.a(paramInt1, paramInt2, paramInt3);
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
          bcfg localbcfg = (bcfg)((ViewGroup)localView).getChildAt(j).getTag(2131381183);
          bcie localbcie = (bcie)((ViewGroup)localView).getChildAt(j).getTag(2131381185);
          bcnr localbcnr = (bcnr)((ViewGroup)localView).getChildAt(j).getTag(2131381188);
          if ((localbcie != null) && (localbcfg != null) && (paramAbsListView != null)) {
            localbcie.a(localbcfg, localbcnr);
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
    this.jdField_a_of_type_Bckm.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbf
 * JD-Core Version:    0.7.0.1
 */