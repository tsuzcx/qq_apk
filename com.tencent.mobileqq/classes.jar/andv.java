import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class andv
{
  public static int a;
  private ande jdField_a_of_type_Ande;
  private andt jdField_a_of_type_Andt;
  private ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  private final int b;
  private int c;
  
  public andv(CmShowRenderView paramCmShowRenderView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = paramCmShowRenderView;
    this.b = paramInt;
  }
  
  public static void a(ArrayList<String> paramArrayList, int[] paramArrayOfInt)
  {
    QLog.i("CmShow_RenderViewController", 1, "CmShow_ preLoadRes start");
    Bundle localBundle = new Bundle();
    localBundle.putIntArray("actionIds", paramArrayOfInt);
    localBundle.putStringArrayList("uins", paramArrayList);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_preload_res", localBundle, new andw());
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onResume");
    }
    if ((a()) && (this.jdField_a_of_type_Ande != null)) {
      this.jdField_a_of_type_Ande.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ande != null) {
      this.jdField_a_of_type_Ande.a(paramInt1, paramInt2);
    }
  }
  
  public void a(anda paramanda)
  {
    if (this.jdField_a_of_type_Andt != null) {
      this.jdField_a_of_type_Andt.a(paramanda);
    }
    if (this.jdField_a_of_type_Ande != null) {
      this.jdField_a_of_type_Ande.a(paramanda);
    }
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    if (this.jdField_a_of_type_Ande != null) {
      this.jdField_a_of_type_Ande.a(paramPlayActionConfig);
    }
  }
  
  @TargetApi(14)
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "initApolloSurfaceView");
    }
    this.jdField_a_of_type_Ande = new ande(paramString, this.b);
    this.jdField_a_of_type_Andt = new andt(this.jdField_a_of_type_Ande, 0);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_Andt);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setDumplicateCreateRenderThread(amme.q);
    this.jdField_a_of_type_Ande.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
    int i = anck.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setInitHeight(i);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Ande != null) {
      this.jdField_a_of_type_Ande.a(paramString, paramInt);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Ande != null) {
      this.jdField_a_of_type_Ande.a(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ande != null) {
      this.jdField_a_of_type_Ande.a(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Ande != null) {
      this.jdField_a_of_type_Ande.a(paramString1, paramString2, paramFloat, paramInt, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ande != null) {
      this.jdField_a_of_type_Ande.a(paramString1, paramString2, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ande != null) {
      this.jdField_a_of_type_Ande.a(paramString, paramBoolean);
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ande != null) {
      this.jdField_a_of_type_Ande.a(paramList, paramBoolean);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onPause");
    }
    if ((a()) && (this.jdField_a_of_type_Ande != null)) {
      this.jdField_a_of_type_Ande.a();
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Ande != null) {
      this.jdField_a_of_type_Ande.a(paramString);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onDestroy ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      ApolloRender localApolloRender = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender();
      if (localApolloRender != null) {
        localApolloRender.queueDestroy();
      }
    }
    if (this.jdField_a_of_type_Ande != null)
    {
      this.jdField_a_of_type_Ande.c();
      this.jdField_a_of_type_Ande = null;
    }
    if (!a())
    {
      QLog.e("CmShow_RenderViewController", 1, new Object[] { "[onDestory] isViewAvailable:", Boolean.valueOf(a()) });
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
    }
    this.c = 0;
    ancv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andv
 * JD-Core Version:    0.7.0.1
 */