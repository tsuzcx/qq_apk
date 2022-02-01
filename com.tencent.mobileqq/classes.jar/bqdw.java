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

public class bqdw
  implements bqva
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<bqjb> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bqdx a;
  private bqjb jdField_a_of_type_Bqjb;
  private bqux jdField_a_of_type_Bqux;
  private DoodleView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  private ElasticImageView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView;
  
  public bqdw(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)paramRelativeLayout.findViewById(2131362998));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramRelativeLayout.findViewById(2131376987));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView = ((ElasticImageView)paramRelativeLayout.findViewById(2131369361));
    this.jdField_a_of_type_Bqux = new bqux(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bqux.a(this);
    c();
    d();
  }
  
  public static String a(@NonNull String paramString)
  {
    if (paramString.getBytes().length <= 24)
    {
      yuk.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk no need to cut out. remark = %s. byte length = %d.", paramString, Integer.valueOf(paramString.getBytes().length));
      return paramString;
    }
    yuk.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk need to cut out. remark = %s. byte length = %d.", paramString, Integer.valueOf(paramString.getBytes().length));
    int k = "...".getBytes().length;
    Object localObject2 = paramString.substring(0, 8);
    int j = ((String)localObject2).getBytes().length;
    int i = 8;
    String str;
    for (Object localObject1 = localObject2; i <= paramString.length(); localObject1 = str)
    {
      if (j + k == 24)
      {
        yuk.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk after cuting out. remark = %s. byte length = %d.", localObject1 + "...", Integer.valueOf((localObject1 + "...").getBytes().length));
        return localObject1 + "...";
      }
      if (j + k > 24)
      {
        yuk.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk after cuting out. remark = %s. byte length = %d.", (String)localObject2 + "...", Integer.valueOf(((String)localObject2 + "...").getBytes().length));
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
    if (this.jdField_a_of_type_Bqdx != null) {
      this.jdField_a_of_type_Bqdx.a(paramInt);
    }
  }
  
  private void c()
  {
    bqkp localbqkp = new bqkr().a(new bqki()).a(720).b(1280).a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig(localbqkp);
  }
  
  private void d()
  {
    int i = 0;
    while (i < bqki.a.length)
    {
      bqjb localbqjb = (bqjb)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bqki.a[i]);
      localbqjb.a(new bqdz(this));
      localbqjb.a(new bqdy(this));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbqjb);
      i += 1;
    }
    this.jdField_a_of_type_Bqjb = ((bqjb)this.jdField_a_of_type_AndroidUtilSparseArray.get(0));
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtCount error. Invalid index.");
      return 0;
    }
    bqjb localbqjb = (bqjb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbqjb == null)
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtCount error. layer is null.");
      return 0;
    }
    return localbqjb.a();
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a();
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtJsonData error. Invalid index.");
      return null;
    }
    bqjb localbqjb = (bqjb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbqjb == null)
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtJsonData error. layer is null.");
      return null;
    }
    return localbqjb.b();
  }
  
  @NonNull
  public List<String> a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size())) {
      return Collections.EMPTY_LIST;
    }
    bqjb localbqjb = (bqjb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbqjb == null) {
      return Collections.EMPTY_LIST;
    }
    return localbqjb.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bqjb != null) {
      this.jdField_a_of_type_Bqjb.k();
    }
  }
  
  public void a(int paramInt)
  {
    yuk.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer. index:" + paramInt);
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer error. Invalid index.");
      return;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer error. Layer is null.");
      return;
    }
    this.jdField_a_of_type_Bqjb = ((bqjb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      bqjb localbqjb = (bqjb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (localbqjb != null) {
        localbqjb.a(false);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_Bqjb.a(true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void a(bqdx parambqdx)
  {
    this.jdField_a_of_type_Bqdx = parambqdx;
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    yuk.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "addAtLabel uin = %s remark = %s name = %s.", paramString1, paramString2, paramString3);
    if (this.jdField_a_of_type_Bqjb.a(paramString1)) {
      return;
    }
    int i = agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_Bqux.a(paramString1, i, i);
    if (localDrawable == null)
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "createStoryFaceDrawable failed, uin=%s, width=%s, height=%s.", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(i) });
      return;
    }
    paramString2 = a(paramString2);
    bqje localbqje = bqri.a(this.jdField_a_of_type_AndroidContentContext, localDrawable, paramString2, 0);
    if (localbqje != null)
    {
      if ((this.jdField_a_of_type_Bqjb.c() == 0) || (this.jdField_a_of_type_Bqjb.d() == 0))
      {
        yuk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "Add the at label while the layer's size is 0. Force to set the layer's size to the screen's size.");
        i = brkm.a;
        int j = brkm.a(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_Bqjb.a(i, j);
      }
      this.jdField_a_of_type_Bqjb.a(paramString1, localDrawable, paramString2, paramString3, localbqje, null);
      return;
    }
    yuk.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "addAtLabel init params failed..");
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
    yuk.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "onDestory");
    this.jdField_a_of_type_Bqux.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqdw
 * JD-Core Version:    0.7.0.1
 */