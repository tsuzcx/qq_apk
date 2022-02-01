import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.linker.LinkerSummaryView;
import java.util.HashMap;
import java.util.Map;

public class bqge
  extends bqgi
  implements DialogInterface.OnDismissListener, bqsn
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  bqsm jdField_a_of_type_Bqsm;
  LinkerSummaryView jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView;
  public Map<String, bqso> a;
  private boolean jdField_a_of_type_Boolean;
  
  public bqge(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    String str = "1";
    if ((paramContext instanceof QIMCameraCaptureActivity)) {
      str = "1";
    }
    for (;;)
    {
      bdll.b(null, "dc00899", "grp_story", "", "video_edit", paramString, 0, 0, str, "", "", "");
      return;
      if ((paramContext instanceof EditVideoActivity)) {
        str = "2";
      } else if ((paramContext instanceof EditPicActivity)) {
        str = "2";
      }
    }
  }
  
  public bqso a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.jdField_a_of_type_Bqso;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setEditing(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.editEditVideoLinker", 2, "editVideoLinker state : " + paramInt2);
      }
    }
    switch (paramInt2)
    {
    default: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setVisibility(4);
  }
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    String str = null;
    super.a(paramInt, parambqua);
    bqso localbqso = a();
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (localbqso != null)
    {
      bool = localbqso.a();
      localObject2 = new StringBuilder().append("editVideoPrePublish: mHasRiched = ").append(bool).append(" , mUrl = ");
      if (localbqso.jdField_a_of_type_JavaLangString != null) {
        break label278;
      }
      localObject1 = "null";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareTitle = ");
      if (localbqso.b != null) {
        break label288;
      }
      localObject1 = "null";
      label87:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareDesc = ");
      if (localbqso.c != null) {
        break label298;
      }
      localObject1 = "null";
      label113:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareThumb = ");
      if (localbqso.d != null) {
        break label308;
      }
      localObject1 = "null";
      label139:
      yuk.b("Q.qqstory.publish.editEditVideoLinker", (String)localObject1);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView == null) {
        break label350;
      }
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.b;
      str = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("editVideoPrePublish: , sourceName = ");
      if (localObject1 != null) {
        break label318;
      }
      localObject2 = "null";
      label202:
      localStringBuilder = localStringBuilder.append((String)localObject2).append(" , sourceIconUrl = ");
      if (str != null) {
        break label325;
      }
      localObject2 = "null";
      label225:
      yuk.b("Q.qqstory.publish.editEditVideoLinker", (String)localObject2);
    }
    for (;;)
    {
      if (bool) {}
      for (localObject1 = wuw.a(localbqso.jdField_a_of_type_JavaLangString, localbqso.b, localbqso.c, str, (String)localObject1);; localObject1 = wuw.a(localbqso.jdField_a_of_type_JavaLangString, true, str, (String)localObject1))
      {
        parambqua.a.setLinkInfo((wuw)localObject1);
        return;
        label278:
        localObject1 = localbqso.jdField_a_of_type_JavaLangString;
        break;
        label288:
        localObject1 = localbqso.b;
        break label87;
        label298:
        localObject1 = localbqso.c;
        break label113;
        label308:
        localObject1 = localbqso.d;
        break label139;
        label318:
        localObject2 = localObject1;
        break label202;
        label325:
        localObject2 = str;
        break label225;
      }
      label350:
      localObject1 = null;
    }
  }
  
  public void a(bqso parambqso)
  {
    String str = parambqso.jdField_a_of_type_JavaLangString;
    if ((!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(str))) {
      this.jdField_a_of_type_JavaUtilMap.put(str, parambqso);
    }
  }
  
  public void a(String paramString)
  {
    bqso localbqso2 = (bqso)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    bqso localbqso1 = localbqso2;
    if (localbqso2 == null) {
      localbqso1 = new bqso(paramString);
    }
    a("clk_added", a());
    d();
    yup.a("video_shoot", "exp_linkbar", 1, 0, new String[] { "", "", "", "" });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setShowShare(false);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.b = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setLinkerObject(localbqso1);
    this.jdField_a_of_type_Bqgk.a(Message.obtain(null, 15, 1, 0));
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bqsm == null)
    {
      this.jdField_a_of_type_Bqsm = new bqsm(a());
      this.jdField_a_of_type_Bqsm.a(this);
    }
    Object localObject = a();
    if ((localObject != null) && (((bqso)localObject).jdField_a_of_type_JavaLangString != null)) {}
    for (localObject = ((bqso)localObject).jdField_a_of_type_JavaLangString;; localObject = null)
    {
      this.jdField_a_of_type_Bqsm.a((String)localObject);
      if ((!paramBoolean) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView == null)) {
        bdll.b(null, "dc00899", "grp_story", "", "video_edit", "clk_linkbutton", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_Bqgk.a().d();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131365678));
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.setMargins(0, 0, 0, a().getDimensionPixelSize(2131298016) + agej.a(17.0F, a()));
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i).getId() == 2131365680)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView = new LinkerSummaryView(a());
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setEditVideoLinker(this);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView, i, localLayoutParams);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Looper.myQueue().addIdleHandler(new bqgf(this));
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView = null;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView = null;
    }
    this.jdField_a_of_type_Bqgk.a(Message.obtain(null, 15, 0, 0));
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setEditing(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqge
 * JD-Core Version:    0.7.0.1
 */