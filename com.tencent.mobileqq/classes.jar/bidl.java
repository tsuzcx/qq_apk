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

public class bidl
  implements biva
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<biis> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bidm a;
  private biis jdField_a_of_type_Biis;
  private biux jdField_a_of_type_Biux;
  private DoodleView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  private ElasticImageView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView;
  
  public bidl(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)paramRelativeLayout.findViewById(2131297294));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramRelativeLayout.findViewById(2131309792));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView = ((ElasticImageView)paramRelativeLayout.findViewById(2131303044));
    this.jdField_a_of_type_Biux = new biux(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Biux.a(this);
    c();
    d();
  }
  
  public static String a(@NonNull String paramString)
  {
    if (paramString.getBytes().length <= 24)
    {
      urk.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk no need to cut out. remark = %s. byte length = %d.", paramString, Integer.valueOf(paramString.getBytes().length));
      return paramString;
    }
    urk.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk need to cut out. remark = %s. byte length = %d.", paramString, Integer.valueOf(paramString.getBytes().length));
    int k = "...".getBytes().length;
    Object localObject2 = paramString.substring(0, 8);
    int j = ((String)localObject2).getBytes().length;
    int i = 8;
    String str;
    for (Object localObject1 = localObject2; i <= paramString.length(); localObject1 = str)
    {
      if (j + k == 24)
      {
        urk.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk after cuting out. remark = %s. byte length = %d.", localObject1 + "...", Integer.valueOf((localObject1 + "...").getBytes().length));
        return localObject1 + "...";
      }
      if (j + k > 24)
      {
        urk.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk after cuting out. remark = %s. byte length = %d.", (String)localObject2 + "...", Integer.valueOf(((String)localObject2 + "...").getBytes().length));
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
    if (this.jdField_a_of_type_Bidm != null) {
      this.jdField_a_of_type_Bidm.a(paramInt);
    }
  }
  
  private void c()
  {
    bikg localbikg = new biki().a(new bijz()).a(720).b(1280).a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig(localbikg);
  }
  
  private void d()
  {
    int i = 0;
    while (i < bijz.a.length)
    {
      biis localbiis = (biis)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bijz.a[i]);
      localbiis.a(new bido(this));
      localbiis.a(new bidn(this));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbiis);
      i += 1;
    }
    this.jdField_a_of_type_Biis = ((biis)this.jdField_a_of_type_AndroidUtilSparseArray.get(0));
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      urk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtCount error. Invalid index.");
      return 0;
    }
    biis localbiis = (biis)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbiis == null)
    {
      urk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtCount error. layer is null.");
      return 0;
    }
    return localbiis.a();
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a();
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      urk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtJsonData error. Invalid index.");
      return null;
    }
    biis localbiis = (biis)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbiis == null)
    {
      urk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtJsonData error. layer is null.");
      return null;
    }
    return localbiis.b();
  }
  
  @NonNull
  public List<String> a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size())) {
      return Collections.EMPTY_LIST;
    }
    biis localbiis = (biis)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbiis == null) {
      return Collections.EMPTY_LIST;
    }
    return localbiis.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Biis != null) {
      this.jdField_a_of_type_Biis.k();
    }
  }
  
  public void a(int paramInt)
  {
    urk.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer. index:" + paramInt);
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      urk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer error. Invalid index.");
      return;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      urk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer error. Layer is null.");
      return;
    }
    this.jdField_a_of_type_Biis = ((biis)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      biis localbiis = (biis)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (localbiis != null) {
        localbiis.a(false);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_Biis.a(true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void a(bidm parambidm)
  {
    this.jdField_a_of_type_Bidm = parambidm;
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    urk.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "addAtLabel uin = %s remark = %s name = %s.", paramString1, paramString2, paramString3);
    if (this.jdField_a_of_type_Biis.a(paramString1)) {
      return;
    }
    int i = aciy.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_Biux.a(paramString1, i, i);
    if (localDrawable == null)
    {
      urk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "createStoryFaceDrawable failed, uin=%s, width=%s, height=%s.", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(i) });
      return;
    }
    paramString2 = a(paramString2);
    biiv localbiiv = biqz.a(this.jdField_a_of_type_AndroidContentContext, localDrawable, paramString2, 0);
    if (localbiiv != null)
    {
      if ((this.jdField_a_of_type_Biis.c() == 0) || (this.jdField_a_of_type_Biis.d() == 0))
      {
        urk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "Add the at label while the layer's size is 0. Force to set the layer's size to the screen's size.");
        i = bjlo.a;
        int j = bjlo.a(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_Biis.a(i, j);
      }
      this.jdField_a_of_type_Biis.a(paramString1, localDrawable, paramString2, paramString3, localbiiv, null);
      return;
    }
    urk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "addAtLabel init params failed..");
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
    urk.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "onDestory");
    this.jdField_a_of_type_Biux.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bidl
 * JD-Core Version:    0.7.0.1
 */