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

public class bmir
  extends bmiv
  implements DialogInterface.OnDismissListener, bmva
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  bmuz jdField_a_of_type_Bmuz;
  LinkerSummaryView jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView;
  public Map<String, bmvb> a;
  private boolean jdField_a_of_type_Boolean;
  
  public bmir(@NonNull bmix parambmix)
  {
    super(parambmix);
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
      azmj.b(null, "dc00899", "grp_story", "", "video_edit", paramString, 0, 0, str, "", "", "");
      return;
      if ((paramContext instanceof EditVideoActivity)) {
        str = "2";
      } else if ((paramContext instanceof EditPicActivity)) {
        str = "2";
      }
    }
  }
  
  public bmvb a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.jdField_a_of_type_Bmvb;
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
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    String str = null;
    super.a(paramInt, parambmwn);
    bmvb localbmvb = a();
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (localbmvb != null)
    {
      bool = localbmvb.a();
      localObject2 = new StringBuilder().append("editVideoPrePublish: mHasRiched = ").append(bool).append(" , mUrl = ");
      if (localbmvb.jdField_a_of_type_JavaLangString != null) {
        break label278;
      }
      localObject1 = "null";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareTitle = ");
      if (localbmvb.b != null) {
        break label288;
      }
      localObject1 = "null";
      label87:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareDesc = ");
      if (localbmvb.c != null) {
        break label298;
      }
      localObject1 = "null";
      label113:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareThumb = ");
      if (localbmvb.d != null) {
        break label308;
      }
      localObject1 = "null";
      label139:
      wsv.b("Q.qqstory.publish.editEditVideoLinker", (String)localObject1);
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
      wsv.b("Q.qqstory.publish.editEditVideoLinker", (String)localObject2);
    }
    for (;;)
    {
      if (bool) {}
      for (localObject1 = utg.a(localbmvb.jdField_a_of_type_JavaLangString, localbmvb.b, localbmvb.c, str, (String)localObject1);; localObject1 = utg.a(localbmvb.jdField_a_of_type_JavaLangString, true, str, (String)localObject1))
      {
        parambmwn.a.setLinkInfo((utg)localObject1);
        return;
        label278:
        localObject1 = localbmvb.jdField_a_of_type_JavaLangString;
        break;
        label288:
        localObject1 = localbmvb.b;
        break label87;
        label298:
        localObject1 = localbmvb.c;
        break label113;
        label308:
        localObject1 = localbmvb.d;
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
  
  public void a(bmvb parambmvb)
  {
    String str = parambmvb.jdField_a_of_type_JavaLangString;
    if ((!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(str))) {
      this.jdField_a_of_type_JavaUtilMap.put(str, parambmvb);
    }
  }
  
  public void a(String paramString)
  {
    bmvb localbmvb2 = (bmvb)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    bmvb localbmvb1 = localbmvb2;
    if (localbmvb2 == null) {
      localbmvb1 = new bmvb(paramString);
    }
    a("clk_added", a());
    d();
    wta.a("video_shoot", "exp_linkbar", 1, 0, new String[] { "", "", "", "" });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setShowShare(false);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.b = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setLinkerObject(localbmvb1);
    this.jdField_a_of_type_Bmix.a(Message.obtain(null, 15, 1, 0));
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bmuz == null)
    {
      this.jdField_a_of_type_Bmuz = new bmuz(a());
      this.jdField_a_of_type_Bmuz.a(this);
    }
    Object localObject = a();
    if ((localObject != null) && (((bmvb)localObject).jdField_a_of_type_JavaLangString != null)) {}
    for (localObject = ((bmvb)localObject).jdField_a_of_type_JavaLangString;; localObject = null)
    {
      this.jdField_a_of_type_Bmuz.a((String)localObject);
      if ((!paramBoolean) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView == null)) {
        azmj.b(null, "dc00899", "grp_story", "", "video_edit", "clk_linkbutton", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_Bmix.a().d();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131365398));
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.setMargins(0, 0, 0, a().getDimensionPixelSize(2131297923) + aekt.a(17.0F, a()));
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i).getId() == 2131365400)
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
    Looper.myQueue().addIdleHandler(new bmis(this));
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
    this.jdField_a_of_type_Bmix.a(Message.obtain(null, 15, 0, 0));
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setEditing(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmir
 * JD-Core Version:    0.7.0.1
 */