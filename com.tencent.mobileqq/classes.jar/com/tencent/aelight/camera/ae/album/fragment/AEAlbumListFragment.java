package com.tencent.aelight.camera.ae.album.fragment;

import com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogic;
import com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicDefault;

public class AEAlbumListFragment
  extends AEAbstractAlbumListFragment
{
  protected AEAlbumListLogic a()
  {
    return AEAlbumListLogicDefault.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */