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

public class bifv
  extends bifz
  implements DialogInterface.OnDismissListener, bisl
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  bisk jdField_a_of_type_Bisk;
  LinkerSummaryView jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView;
  public Map<String, bism> a;
  private boolean jdField_a_of_type_Boolean;
  
  public bifv(@NonNull bigb parambigb)
  {
    super(parambigb);
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
      awqx.b(null, "dc00899", "grp_story", "", "video_edit", paramString, 0, 0, str, "", "", "");
      return;
      if ((paramContext instanceof EditVideoActivity)) {
        str = "2";
      } else if ((paramContext instanceof EditPicActivity)) {
        str = "2";
      }
    }
  }
  
  public bism a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.jdField_a_of_type_Bism;
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
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    String str = null;
    super.a(paramInt, parambitz);
    bism localbism = a();
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (localbism != null)
    {
      bool = localbism.a();
      localObject2 = new StringBuilder().append("editVideoPrePublish: mHasRiched = ").append(bool).append(" , mUrl = ");
      if (localbism.jdField_a_of_type_JavaLangString != null) {
        break label278;
      }
      localObject1 = "null";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareTitle = ");
      if (localbism.b != null) {
        break label288;
      }
      localObject1 = "null";
      label87:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareDesc = ");
      if (localbism.c != null) {
        break label298;
      }
      localObject1 = "null";
      label113:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareThumb = ");
      if (localbism.d != null) {
        break label308;
      }
      localObject1 = "null";
      label139:
      urk.b("Q.qqstory.publish.editEditVideoLinker", (String)localObject1);
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
      urk.b("Q.qqstory.publish.editEditVideoLinker", (String)localObject2);
    }
    for (;;)
    {
      if (bool) {}
      for (localObject1 = srv.a(localbism.jdField_a_of_type_JavaLangString, localbism.b, localbism.c, str, (String)localObject1);; localObject1 = srv.a(localbism.jdField_a_of_type_JavaLangString, true, str, (String)localObject1))
      {
        parambitz.a.setLinkInfo((srv)localObject1);
        return;
        label278:
        localObject1 = localbism.jdField_a_of_type_JavaLangString;
        break;
        label288:
        localObject1 = localbism.b;
        break label87;
        label298:
        localObject1 = localbism.c;
        break label113;
        label308:
        localObject1 = localbism.d;
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
  
  public void a(bism parambism)
  {
    String str = parambism.jdField_a_of_type_JavaLangString;
    if ((!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(str))) {
      this.jdField_a_of_type_JavaUtilMap.put(str, parambism);
    }
  }
  
  public void a(String paramString)
  {
    bism localbism2 = (bism)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    bism localbism1 = localbism2;
    if (localbism2 == null) {
      localbism1 = new bism(paramString);
    }
    a("clk_added", a());
    d();
    urp.a("video_shoot", "exp_linkbar", 1, 0, new String[] { "", "", "", "" });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setShowShare(false);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.b = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setLinkerObject(localbism1);
    this.jdField_a_of_type_Bigb.a(Message.obtain(null, 15, 1, 0));
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bisk == null)
    {
      this.jdField_a_of_type_Bisk = new bisk(a());
      this.jdField_a_of_type_Bisk.a(this);
    }
    Object localObject = a();
    if ((localObject != null) && (((bism)localObject).jdField_a_of_type_JavaLangString != null)) {}
    for (localObject = ((bism)localObject).jdField_a_of_type_JavaLangString;; localObject = null)
    {
      this.jdField_a_of_type_Bisk.a((String)localObject);
      if ((!paramBoolean) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView == null)) {
        awqx.b(null, "dc00899", "grp_story", "", "video_edit", "clk_linkbutton", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_Bigb.a().d();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131299746));
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.setMargins(0, 0, 0, a().getDimensionPixelSize(2131166812) + aciy.a(17.0F, a()));
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i).getId() == 2131299748)
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
    Looper.myQueue().addIdleHandler(new bifw(this));
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
    this.jdField_a_of_type_Bigb.a(Message.obtain(null, 15, 0, 0));
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setEditing(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bifv
 * JD-Core Version:    0.7.0.1
 */