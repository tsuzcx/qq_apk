package com.tencent.av.opengl.program;

import ltv;
import ltw;
import ltx;

public class DrawProgram
  extends TextureProgram
{
  public DrawProgram()
  {
    super("uniform mat4 uMatrix;attribute vec2 aPosition;void main() {vec4 pos = vec4 (aPosition, 0.0, 1.0);gl_Position  = uMatrix * pos;}", "precision mediump float;uniform vec4 uColor;void main() {gl_FragColor = uColor;}", new ltw[] { new ltv("aPosition"), new ltx("uMatrix"), new ltx("uColor") }, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.program.DrawProgram
 * JD-Core Version:    0.7.0.1
 */