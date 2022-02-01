package com.tencent.TMG.ptt;

import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class FileTransfer$1
  implements Runnable
{
  FileTransfer$1(FileTransfer paramFileTransfer, String paramString1, int paramInt, String paramString2, String paramString3, PttListener.UploadFileListener paramUploadFileListener) {}
  
  public void run()
  {
    Object localObject9 = "";
    Object localObject1 = FileTransfer.access$000(this.this$0, this.val$srcPath);
    int i = 8193;
    int j = 8195;
    Object localObject10 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    String str = null;
    Object localObject3;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = localObject1;
      localObject2 = localObject3;
      localObject4 = localObject2;
    }
    else
    {
      Object localObject11 = SHA1Utils.getFileSHA1(this.val$srcPath);
      try
      {
        localObject2 = new FileInputStream((File)localObject1);
        try
        {
          int k = ((FileInputStream)localObject2).available();
          if ((k > 0) && (k <= this.val$maxSize))
          {
            localObject1 = (HttpURLConnection)new URL(this.val$strUrl).openConnection();
            try
            {
              ((HttpURLConnection)localObject1).setConnectTimeout(5000);
              ((HttpURLConnection)localObject1).setReadTimeout(30000);
              ((HttpURLConnection)localObject1).setDoOutput(true);
              ((HttpURLConnection)localObject1).setDoInput(true);
              ((HttpURLConnection)localObject1).setUseCaches(false);
              ((HttpURLConnection)localObject1).setRequestMethod("POST");
              ((HttpURLConnection)localObject1).setRequestProperty("Connection", "Keep-Alive");
              ((HttpURLConnection)localObject1).setRequestProperty("Authorization", this.val$sign);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("multipart/form-data; boundary=");
              ((StringBuilder)localObject3).append("----------------------------aa502a40917c");
              ((HttpURLConnection)localObject1).setRequestProperty("Content-Type", ((StringBuilder)localObject3).toString());
              localObject3 = new DataOutputStream(((HttpURLConnection)localObject1).getOutputStream());
              try
              {
                localObject5 = new HashMap(3);
                ((Map)localObject5).put("op", "upload");
                ((Map)localObject5).put("sha", localObject11);
                ((Map)localObject5).put("biz_attr", "");
                localObject5 = FileTransfer.access$100(this.this$0, (Map)localObject5, "----------------------------aa502a40917c");
                localObject11 = new StringBuilder();
                ((StringBuilder)localObject11).append((String)localObject5);
                ((StringBuilder)localObject11).append("--");
                ((StringBuilder)localObject11).append("----------------------------aa502a40917c");
                ((StringBuilder)localObject11).append("\r\n");
                localObject5 = ((StringBuilder)localObject11).toString();
                localObject11 = new StringBuilder();
                ((StringBuilder)localObject11).append((String)localObject5);
                ((StringBuilder)localObject11).append("Content-Disposition: form-data; name=\"filecontent\"; filename=\"");
                ((StringBuilder)localObject11).append(this.val$srcPath);
                ((StringBuilder)localObject11).append("\"\r\n");
                localObject5 = ((StringBuilder)localObject11).toString();
                localObject11 = new StringBuilder();
                ((StringBuilder)localObject11).append((String)localObject5);
                ((StringBuilder)localObject11).append("Content-Type: application/octet-stream\r\n\r\n");
                ((OutputStream)localObject3).write(((StringBuilder)localObject11).toString().getBytes());
                localObject5 = new byte[1024];
                for (;;)
                {
                  k = ((FileInputStream)localObject2).read((byte[])localObject5);
                  if (k == -1) {
                    break;
                  }
                  ((OutputStream)localObject3).write((byte[])localObject5, 0, k);
                }
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("\r\n--");
                ((StringBuilder)localObject5).append("----------------------------aa502a40917c");
                ((StringBuilder)localObject5).append("--\r\n");
                ((OutputStream)localObject3).write(((StringBuilder)localObject5).toString().getBytes());
                ((OutputStream)localObject3).flush();
                k = ((HttpURLConnection)localObject1).getResponseCode();
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("uploadFileImpl|rcode=");
                ((StringBuilder)localObject5).append(k);
                Log.i("FileTransfer", ((StringBuilder)localObject5).toString());
                if (k == 200)
                {
                  localObject4 = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject1).getInputStream()));
                  localObject5 = localObject9;
                  try
                  {
                    for (;;)
                    {
                      localObject9 = ((BufferedReader)localObject4).readLine();
                      if (localObject9 == null) {
                        break;
                      }
                      localObject11 = new StringBuilder();
                      ((StringBuilder)localObject11).append((String)localObject5);
                      ((StringBuilder)localObject11).append((String)localObject9);
                      localObject9 = ((StringBuilder)localObject11).toString();
                      localObject5 = localObject9;
                    }
                    localObject9 = new StringBuilder();
                    ((StringBuilder)localObject9).append("uploadFileImpl|upload result=");
                    ((StringBuilder)localObject9).append((String)localObject5);
                    Log.d("FileTransfer", ((StringBuilder)localObject9).toString());
                    localObject9 = new JSONObject((String)localObject5);
                    k = ((JSONObject)localObject9).getInt("code");
                    if (k == 0)
                    {
                      str = ((JSONObject)localObject9).getJSONObject("data").getString("source_url");
                      i = 0;
                    }
                    else
                    {
                      localObject9 = ((JSONObject)localObject9).getString("message");
                      localObject11 = new StringBuilder();
                      ((StringBuilder)localObject11).append("uploadFileImpl|upload failed. code =");
                      ((StringBuilder)localObject11).append(k);
                      ((StringBuilder)localObject11).append(", message=");
                      ((StringBuilder)localObject11).append((String)localObject9);
                      Log.e("FileTransfer", ((StringBuilder)localObject11).toString());
                      i = j;
                    }
                    localObject5 = localObject1;
                    localObject1 = localObject4;
                    localObject4 = localObject3;
                  }
                  catch (JSONException localJSONException1)
                  {
                    localObject9 = localObject5;
                    localObject5 = localObject1;
                    localObject1 = localObject4;
                    break label1090;
                  }
                  catch (IOException localIOException4)
                  {
                    localObject5 = localObject1;
                    localObject1 = localObject4;
                    break label1152;
                  }
                  catch (UnknownHostException localUnknownHostException1)
                  {
                    localObject5 = localObject1;
                    localObject1 = localObject4;
                    break label1244;
                  }
                }
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("uploadFileImpl|upload file failed. http response code =");
                ((StringBuilder)localObject5).append(k);
                Log.e("FileTransfer", ((StringBuilder)localObject5).toString());
                Object localObject6 = localObject4;
              }
              catch (JSONException localJSONException2)
              {
                localObject4 = null;
                localObject5 = localObject1;
                localObject1 = localObject4;
                break label1090;
              }
              catch (IOException localIOException5)
              {
                localObject4 = null;
                localObject5 = localObject1;
                localObject1 = localObject4;
                break label1152;
              }
              catch (UnknownHostException localUnknownHostException2)
              {
                localObject4 = null;
                localObject5 = localObject1;
                localObject1 = localObject4;
                break label1244;
              }
              localObject1 = new StringBuilder();
            }
            catch (JSONException localJSONException3) {}catch (IOException localIOException6)
            {
              break label1034;
            }
            catch (UnknownHostException localUnknownHostException3)
            {
              break label1056;
            }
          }
          else
          {
            ((StringBuilder)localObject1).append("uploadFileImpl| file size is invalid. path=");
            ((StringBuilder)localObject1).append(this.val$srcPath);
            ((StringBuilder)localObject1).append(", size=");
            ((StringBuilder)localObject1).append(k);
            Log.e("FileTransfer", ((StringBuilder)localObject1).toString());
            localObject1 = null;
            localObject3 = localObject1;
            localObject4 = localObject3;
          }
        }
        catch (JSONException localJSONException4)
        {
          localObject1 = null;
          localObject4 = null;
          localObject3 = null;
          localObject5 = localObject1;
          localObject1 = localObject4;
        }
        catch (IOException localIOException7)
        {
          localObject1 = null;
          localObject4 = null;
          localObject3 = null;
          localObject5 = localObject1;
          localObject1 = localObject4;
        }
        catch (UnknownHostException localUnknownHostException4)
        {
          label1034:
          localObject1 = null;
          label1056:
          localObject4 = null;
          localObject3 = null;
          localObject5 = localObject1;
          localObject1 = localObject4;
        }
        label1090:
        Object localObject7;
        label1152:
        Log.e("FileTransfer", "uploadFileImpl|upload file failed. neteork is invalid.");
      }
      catch (JSONException localJSONException5)
      {
        localObject5 = null;
        localObject1 = localObject5;
        localObject2 = localObject1;
        localObject3 = localObject2;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("uploadFileImpl|upload file failed. response josn is invalid. result=");
        ((StringBuilder)localObject4).append((String)localObject9);
        Log.e("FileTransfer", ((StringBuilder)localObject4).toString());
        localJSONException5.printStackTrace();
      }
      catch (IOException localIOException8)
      {
        localObject5 = null;
        localObject1 = localObject5;
        localObject2 = localObject1;
        localObject3 = localObject2;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("uploadFileImpl|upload file failed. io exception. path=");
        ((StringBuilder)localObject4).append(this.val$srcPath);
        Log.e("FileTransfer", ((StringBuilder)localObject4).toString());
        localIOException8.printStackTrace();
        localObject4 = localObject3;
        localObject7 = localObject10;
        localObject3 = localObject7;
        localObject7 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject5;
        localObject5 = localObject7;
        break label1289;
      }
      catch (UnknownHostException localUnknownHostException5)
      {
        localObject5 = null;
        localObject1 = localObject5;
        localObject2 = localObject1;
        localObject3 = localObject2;
      }
      label1244:
      localUnknownHostException5.printStackTrace();
      Object localObject8 = localObject1;
      localObject1 = localObject5;
      localObject9 = null;
      i = 8195;
      localObject4 = localObject3;
      localObject5 = localObject8;
      localObject3 = localObject1;
      localObject1 = localObject9;
    }
    label1289:
    if (localObject2 != null) {
      try
      {
        ((FileInputStream)localObject2).close();
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
    if (localObject4 != null) {
      try
      {
        ((OutputStream)localObject4).close();
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
      }
    }
    if (localObject5 != null) {
      try
      {
        ((BufferedReader)localObject5).close();
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
      }
    }
    if (localObject3 != null) {
      ((HttpURLConnection)localObject3).disconnect();
    }
    PttListener.UploadFileListener localUploadFileListener = this.val$monitor;
    if (localUploadFileListener != null) {
      localUploadFileListener.onCompleted(i, this.val$srcPath, (String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.FileTransfer.1
 * JD-Core Version:    0.7.0.1
 */