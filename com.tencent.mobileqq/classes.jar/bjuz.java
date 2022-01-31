import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.widget.RelativeLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import java.util.Collections;
import java.util.List;

public class bjuz
  implements bkmd
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<bkae> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bjva a;
  private bkae jdField_a_of_type_Bkae;
  private bkma jdField_a_of_type_Bkma;
  private DoodleView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  private ElasticImageView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView;
  
  public bjuz(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)paramRelativeLayout.findViewById(2131362833));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramRelativeLayout.findViewById(2131375553));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView = ((ElasticImageView)paramRelativeLayout.findViewById(2131368680));
    this.jdField_a_of_type_Bkma = new bkma(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bkma.a(this);
    c();
    d();
  }
  
  public static String a(@NonNull String paramString)
  {
    if (paramString.getBytes().length <= 24)
    {
      ved.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk no need to cut out. remark = %s. byte length = %d.", paramString, Integer.valueOf(paramString.getBytes().length));
      return paramString;
    }
    ved.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk need to cut out. remark = %s. byte length = %d.", paramString, Integer.valueOf(paramString.getBytes().length));
    int k = "...".getBytes().length;
    Object localObject2 = paramString.substring(0, 8);
    int j = ((String)localObject2).getBytes().length;
    int i = 8;
    String str;
    for (Object localObject1 = localObject2; i <= paramString.length(); localObject1 = str)
    {
      if (j + k == 24)
      {
        ved.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk after cuting out. remark = %s. byte length = %d.", localObject1 + "...", Integer.valueOf((localObject1 + "...").getBytes().length));
        return localObject1 + "...";
      }
      if (j + k > 24)
      {
        ved.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk after cuting out. remark = %s. byte length = %d.", (String)localObject2 + "...", Integer.valueOf(((String)localObject2 + "...").getBytes().length));
        return (String)localObject2 + "...";
      }
      i += 1;
      str = paramString.substring(0, i);
      j = str.getBytes().length;
      localObject2 = localObject1;
    }
    return localObject1;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bjva != null) {
      this.jdField_a_of_type_Bjva.a(paramInt);
    }
  }
  
  private void c()
  {
    bkbs localbkbs = new bkbu().a(new bkbl()).a(720).b(1280).a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig(localbkbs);
  }
  
  private void d()
  {
    int i = 0;
    while (i < bkbl.a.length)
    {
      bkae localbkae = (bkae)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bkbl.a[i]);
      localbkae.a(new bjvc(this));
      localbkae.a(new bjvb(this));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbkae);
      i += 1;
    }
    this.jdField_a_of_type_Bkae = ((bkae)this.jdField_a_of_type_AndroidUtilSparseArray.get(0));
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      ved.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtCount error. Invalid index.");
      return 0;
    }
    bkae localbkae = (bkae)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbkae == null)
    {
      ved.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtCount error. layer is null.");
      return 0;
    }
    return localbkae.a();
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a();
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      ved.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtJsonData error. Invalid index.");
      return null;
    }
    bkae localbkae = (bkae)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbkae == null)
    {
      ved.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtJsonData error. layer is null.");
      return null;
    }
    return localbkae.b();
  }
  
  @NonNull
  public List<String> a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size())) {
      return Collections.EMPTY_LIST;
    }
    bkae localbkae = (bkae)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbkae == null) {
      return Collections.EMPTY_LIST;
    }
    return localbkae.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkae != null) {
      this.jdField_a_of_type_Bkae.k();
    }
  }
  
  public void a(int paramInt)
  {
    ved.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer. index:" + paramInt);
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      ved.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer error. Invalid index.");
      return;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      ved.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer error. Layer is null.");
      return;
    }
    this.jdField_a_of_type_Bkae = ((bkae)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      bkae localbkae = (bkae)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (localbkae != null) {
        localbkae.a(false);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_Bkae.a(true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void a(bjva parambjva)
  {
    this.jdField_a_of_type_Bjva = parambjva;
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    ved.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "addAtLabel uin = %s remark = %s name = %s.", paramString1, paramString2, paramString3);
    if (this.jdField_a_of_type_Bkae.a(paramString1)) {
      return;
    }
    int i = actj.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_Bkma.a(paramString1, i, i);
    if (localDrawable == null)
    {
      ved.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "createStoryFaceDrawable failed, uin=%s, width=%s, height=%s.", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(i) });
      return;
    }
    paramString2 = a(paramString2);
    bkah localbkah = bkil.a(this.jdField_a_of_type_AndroidContentContext, localDrawable, paramString2, 0);
    if (localbkah != null)
    {
      if ((this.jdField_a_of_type_Bkae.c() == 0) || (this.jdField_a_of_type_Bkae.d() == 0))
      {
        ved.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "Add the at label while the layer's size is 0. Force to set the layer's size to the screen's size.");
        i = blcq.a;
        int j = blcq.a(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_Bkae.a(i, j);
      }
      this.jdField_a_of_type_Bkae.a(paramString1, localDrawable, paramString2, paramString3, localbkah, null);
      return;
    }
    ved.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "addAtLabel init params failed..");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c();
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramString);
  }
  
  public void b()
  {
    ved.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "onDestory");
    this.jdField_a_of_type_Bkma.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjuz
 * JD-Core Version:    0.7.0.1
 */